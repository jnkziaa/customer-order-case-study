package com.jnkziaa.customerordercasestudy.dto;


import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAdditionRequest {
    private ProductInfo productInfo;
}
