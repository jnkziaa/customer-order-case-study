package com.jnkziaa.customerordercasestudy.service;

import com.jnkziaa.customerordercasestudy.dto.ProductAdditionRequest;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import com.jnkziaa.customerordercasestudy.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    /*
    @Transactional //connection starts here
    public void saveProductInfo(){

        Product product = new Product();

        for(int i = 1; i <= 10; i++){
            product.setIdPRODUCT(i);
            product.setPROD_NAME("Test Product "  + i);
            productInfoRepository.saveProduct(product);
        }


    }

    //commit
    //close

     */

    @Transactional
    public void saveProductInfo(ProductAdditionRequest request){
        ProductInfo productInfo = request.getProductInfo();
        productInfoRepository.save(productInfo);
    }
}
