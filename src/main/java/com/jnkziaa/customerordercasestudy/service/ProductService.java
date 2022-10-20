package com.jnkziaa.customerordercasestudy.service;

import com.jnkziaa.customerordercasestudy.dto.Product;
import com.jnkziaa.customerordercasestudy.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Transactional //connection starts here
    public void saveProductInfo(){

        Product product = new Product();

        for(int i = 1; i <= 10; i++){
            product.setIdPRODUCT(i);
            product.setPROD_NAME("Test Product "  + i);
            productRepo.saveProduct(product);
        }


    }

    //commit
    //close
}
