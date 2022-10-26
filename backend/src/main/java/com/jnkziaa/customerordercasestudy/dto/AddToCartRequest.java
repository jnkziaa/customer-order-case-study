package com.jnkziaa.customerordercasestudy.dto;


import com.jnkziaa.customerordercasestudy.entity.CartItemsInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest {
    public CartItemsInfo cartItemsInfo;
}
