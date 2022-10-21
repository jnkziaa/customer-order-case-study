package com.jnkziaa.customerordercasestudy;

import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseAcknowledgement;
import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseRequest;
import com.jnkziaa.customerordercasestudy.dto.ProductAdditionRequest;
import com.jnkziaa.customerordercasestudy.service.CustomerPurchaseService;
import com.jnkziaa.customerordercasestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CustomerOrderCaseStudyApplication {

    @Autowired
    private CustomerPurchaseService service;

    @Autowired
    private ProductService productService;

    @PostMapping("/customerPurchase")
    public CustomerPurchaseAcknowledgement customerPurchase(@RequestBody CustomerPurchaseRequest request) {
        return service.customerPurchase(request);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductAdditionRequest request){
        productService.saveProductInfo(request);
    }

    @GetMapping("/productsAvailable")
    public void showProducts(){

    }

    public static void main(String[] args) {

        SpringApplication.run(CustomerOrderCaseStudyApplication.class, args);
    }

}
