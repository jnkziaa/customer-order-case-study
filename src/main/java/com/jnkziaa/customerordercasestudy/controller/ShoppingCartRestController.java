package com.jnkziaa.customerordercasestudy.controller;


import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseAcknowledgement;
import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseRequest;
import com.jnkziaa.customerordercasestudy.dto.ProductAdditionRequest;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import com.jnkziaa.customerordercasestudy.service.CustomerPurchaseService;
import com.jnkziaa.customerordercasestudy.service.CustomerService;
import com.jnkziaa.customerordercasestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductInfo>> getAllProducts(){
        List<ProductInfo> productInfoList = productService.getAllProducts();

        return ResponseEntity.ok(productInfoList);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductAdditionRequest request){
        productService.saveProductInfo(request);
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
