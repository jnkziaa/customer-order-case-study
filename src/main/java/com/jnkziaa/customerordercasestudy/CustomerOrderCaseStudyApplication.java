package com.jnkziaa.customerordercasestudy;

import com.jnkziaa.customerordercasestudy.config.ProductConfig;
import com.jnkziaa.customerordercasestudy.dto.Product;
import com.jnkziaa.customerordercasestudy.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerOrderCaseStudyApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        context.registerShutdownHook();

        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProductInfo();

        context.close();
        //SpringApplication.run(CustomerOrderCaseStudyApplication.class, args);
    }

}
