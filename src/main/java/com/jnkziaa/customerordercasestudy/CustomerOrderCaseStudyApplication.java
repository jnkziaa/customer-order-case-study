package com.jnkziaa.customerordercasestudy;

import com.jnkziaa.customerordercasestudy.config.ProductConfig;
import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseAcknowledgement;
import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseRequest;
import com.jnkziaa.customerordercasestudy.dto.Product;
import com.jnkziaa.customerordercasestudy.dto.ProductAdditionRequest;
import com.jnkziaa.customerordercasestudy.service.CustomerPurchaseService;
import com.jnkziaa.customerordercasestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
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

    public static void main(String[] args) {

        SpringApplication.run(CustomerOrderCaseStudyApplication.class, args);
    }

}
