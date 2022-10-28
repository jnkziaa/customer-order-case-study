package com.jnkziaa.customerordercasestudy.service;

import com.jnkziaa.customerordercasestudy.dto.ProductAdditionRequest;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import com.jnkziaa.customerordercasestudy.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    public ProductService(ProductInfoRepository productInfoRepository){
        this.productInfoRepository = productInfoRepository;
    }

    public List<ProductInfo> getAllProducts(){
        return this.productInfoRepository.findAll();
    }

    @Transactional
    public void saveProductInfo(ProductAdditionRequest request){
        ProductInfo productInfo = request.getProductInfo();
        productInfoRepository.save(productInfo);
    }


    public ProductInfo getSpecificProduct(Long pid) {

        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(pid);


        return productInfoOptional.get();

    }
}
