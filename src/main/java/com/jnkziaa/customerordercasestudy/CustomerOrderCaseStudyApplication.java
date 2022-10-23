package com.jnkziaa.customerordercasestudy;

import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseAcknowledgement;
//import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseRequest;
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
public class CustomerOrderCaseStudyApplication {


    public static void main(String[] args) {

        SpringApplication.run(CustomerOrderCaseStudyApplication.class, args);
    }

}
