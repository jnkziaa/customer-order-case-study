package com.jnkziaa.customerordercasestudy.controller;


import com.jnkziaa.customerordercasestudy.dto.*;
import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import com.jnkziaa.customerordercasestudy.entity.OrderInfo;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import com.jnkziaa.customerordercasestudy.service.CustomerPurchaseService;
import com.jnkziaa.customerordercasestudy.service.CustomerService;
import com.jnkziaa.customerordercasestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {

    @Autowired
    private CustomerPurchaseService customerPurchaseService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    public ShoppingCartRestController(CustomerPurchaseService customerPurchaseService, ProductService productService, CustomerService customerService) {
        this.customerPurchaseService = customerPurchaseService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductAdditionRequest request){
        productService.saveProductInfo(request);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductInfo>> getAllProducts(){
        List<ProductInfo> productInfoList = productService.getAllProducts();

        return ResponseEntity.ok(productInfoList);
    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<OrderInfo> getOrderInfoDetails(@PathVariable Long orderId){
        OrderInfo orderInfo = customerPurchaseService.getOrderDetails(orderId);
        return ResponseEntity.ok(orderInfo);
    }


    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        double amount = customerPurchaseService.getShoppingCartTotal(orderDTO.getCartItems());

        CustomerInfo customerInfo = new CustomerInfo(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
        Long customerIdInDataBase = customerService.isCustomerPresent(customerInfo);

        if(customerIdInDataBase != null){
            customerInfo.setCID(customerIdInDataBase);
        }
        else{
            customerInfo = customerService.saveCustomer(customerInfo);
        }

        OrderInfo orderInfo = new OrderInfo(orderDTO.getOrderDescription(), customerInfo, orderDTO.getCartItems());
        orderInfo = customerPurchaseService.saveOrder(orderInfo);

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(String.valueOf(new Date().getDate()));
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(100000));
        responseOrderDTO.setOrderID(orderInfo.getOID());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

        return ResponseEntity.ok(responseOrderDTO);


    }
    /*
    @PostMapping("/customerPurchase")
    public CustomerPurchaseAcknowledgement customerPurchase(@RequestBody CustomerPurchaseRequest request) {
        return customerPurchaseService.customerPurchase(request);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductAdditionRequest request){
        productService.saveProductInfo(request);
    }

    @GetMapping("/productsAvailable")
    public void showProducts(){

    }*/

}
