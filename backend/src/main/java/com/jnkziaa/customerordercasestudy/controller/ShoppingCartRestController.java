package com.jnkziaa.customerordercasestudy.controller;


import com.jnkziaa.customerordercasestudy.dto.*;
import com.jnkziaa.customerordercasestudy.entity.*;
import com.jnkziaa.customerordercasestudy.repository.ProductInfoRepository;
import com.jnkziaa.customerordercasestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {

    @Autowired
    private CustomerPurchaseService customerPurchaseService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShowCartItemsService showCartItemsService;
    @Autowired
    private CustomerRegistrationService customerRegistrationService;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private ArchivedOrderService archivedOrderService;

    public ShoppingCartRestController(CustomerPurchaseService customerPurchaseService,
                                      ProductService productService,
                                      CustomerService customerService,
                                      ShowCartItemsService showCartItemsService,
                                      CustomerRegistrationService customerRegistrationService,
                                      ProductInfoRepository productInfoRepository,
                                      ArchivedOrderService archivedOrderService
                                      ) {
        this.customerPurchaseService = customerPurchaseService;
        this.productService = productService;
        this.customerService = customerService;
        this.showCartItemsService = showCartItemsService;
        this.customerRegistrationService = customerRegistrationService;
        this.productInfoRepository = productInfoRepository;
        this.archivedOrderService = archivedOrderService;
    }



    //@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductAdditionRequest request){
        productService.saveProductInfo(request);
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/products")
    public ResponseEntity<List<ProductInfo>> getAllProducts(){
        List<ProductInfo> productInfoList = productService.getAllProducts();

        return ResponseEntity.ok(productInfoList);
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/products/{pid}")
    public ResponseEntity<ProductInfo> getSpecificProduct(@PathVariable Long pid){
        ProductInfo returnProduct = productService.getSpecificProduct(pid);

        return ResponseEntity.ok(returnProduct);
    }

   // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addValidUser")
    public void addValidUser(@RequestBody UserAdditionRequest request){
        customerRegistrationService.saveCustomerInfo(request);
    }

    @GetMapping("/ShowAllValidUsers")
    public ResponseEntity<List<CustomerInfo>> getAllValidUsers(){
        List<CustomerInfo> customerInfoList = customerRegistrationService.customerInfoList();

        return ResponseEntity.ok(customerInfoList);
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addToCart")
    public void showProductsInCart(@RequestBody AddToCartRequest request){
        showCartItemsService.saveCartItemsInfo(request);
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllItemsInCart/{cID}")
    public ResponseEntity<List<CartItemsInfo>> getAllItemsInCart(@PathVariable Long cID){

        List<CartItemsInfo> cartItemsInfoList = new ArrayList<>();

        for(CartItemsInfo items : showCartItemsService.cartItemsInfoList()){
            if(Objects.equals(items.getCID(), cID)){
                cartItemsInfoList.add(items);
            }
        }

        double totalCartAmount = 0.0;
        double singleCartAmount = 0.0;
        int availableQuantity = 0;

        for(CartItemsInfo items : cartItemsInfoList) {
            String productName = items.getProductName();


            Optional<ProductInfo> productInfoIDs = Optional.ofNullable(productInfoRepository.findByProductName(productName));

            if(productInfoIDs.isPresent()){

                ProductInfo productInfo2 = productInfoIDs.get();
                //System.out.println("PRODUCT1 ARE :" + productInfo1);

                System.out.println("AVAILABLE QUANTITY: " + productInfo2.getProductAvailableQuantity() + " CART QUANTITY : " + items.getProductQuantityAmount());
                if(productInfo2.getProductAvailableQuantity() < items.getProductQuantityAmount()){

                    singleCartAmount = productInfo2.getProductPrice() * productInfo2.getProductAvailableQuantity();

                    items.setProductQuantityAmount(productInfo2.getProductAvailableQuantity());
                }else{

                    singleCartAmount = items.getProductQuantityAmount() * productInfo2.getProductPrice();

                    availableQuantity = productInfo2.getProductAvailableQuantity() - items.getProductQuantityAmount();
                }

                System.out.println("CURRENT TOTAL ARE " + singleCartAmount + " " + totalCartAmount);
                totalCartAmount = totalCartAmount + singleCartAmount;
                productInfo2.setProductAvailableQuantity(availableQuantity);
                availableQuantity = 0;
                items.setProductID(productInfo2.getPID());
                items.setProductName(productInfo2.getProductName());
                items.setTotalCost(singleCartAmount);
                items.setAccumulatedCost(totalCartAmount);
            }
        }

        return ResponseEntity.ok(cartItemsInfoList);
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/clearItemsInCart")
    public void clearItemsInCart(){
        List<CartItemsInfo> cartItemsInfoList = showCartItemsService.cartItemsInfoList();
        cartItemsInfoList.clear();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){


        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        List<CompleteOrderArchivedInfo> cartItemsInfoList = new ArrayList<>();

        for(CartItemsInfo items : showCartItemsService.cartItemsInfoList()){
            if(Objects.equals(items.getCID(), orderDTO.getCID())){
                CompleteOrderArchivedInfo temp = new CompleteOrderArchivedInfo(items.getProductID(),
                        items.getProductName(),
                        items.getCID(),
                        items.getProductQuantityAmount(),
                        items.getTotalCost());
                cartItemsInfoList.add(temp);
                archivedOrderService.saveArchivedItemsInfo(temp);
            }
        }


        orderDTO.setCartItems(cartItemsInfoList);

        double amount = customerPurchaseService.getShoppingCartTotal(orderDTO.getCartItems());

        for(CustomerInfo customers : customerRegistrationService.customerInfoList()){
            if(Objects.equals(orderDTO.getCID(), customers.getCID())){
                orderDTO.setCustomerEmail(customers.getEmail());
                orderDTO.setCustomerUsername(customers.getUsername());
                customers.setCurrentBalance(customers.getCurrentBalance() - amount);
            }
        }


        CustomerInfo customerInfo = new CustomerInfo(orderDTO.getCustomerUsername(), orderDTO.getCustomerEmail());
        System.out.println("THIS CUSTOMER HAS THIS MUCH MONEY " + customerInfo.getCurrentBalance());
        Long customerIdInDataBase = customerService.isCustomerPresent(customerInfo);

        if(customerIdInDataBase != null){
            customerInfo.setCID(customerIdInDataBase);
        }
        else{
            customerInfo = customerService.saveCustomer(customerInfo);
        }


        String invoiceNumber = String.valueOf(UUID.randomUUID());
        String orderDate = String.valueOf(new Date());
        System.out.println("TOTAL AMOUNT IS :" + amount);

        OrderInfo orderInfo = new OrderInfo(invoiceNumber, amount, orderDate, orderDTO.getOrderDescription(), orderDTO.getCartItems(), customerInfo);

        orderInfo = customerPurchaseService.saveOrder(orderInfo);

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(orderDate);
        responseOrderDTO.setInvoiceNumber(invoiceNumber);
        responseOrderDTO.setOID(orderInfo.getOID());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

        //showCartItemsService.deleteByID(orderDTO.getCID());
        return ResponseEntity.ok(responseOrderDTO);



        //return ResponseEntity.ok(new ResponseOrderDTO());
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<OrderInfo> getOrderInfoDetails(@PathVariable Long orderId){
        OrderInfo orderInfo = customerPurchaseService.getOrderDetails(orderId);
        return ResponseEntity.ok(orderInfo);
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
