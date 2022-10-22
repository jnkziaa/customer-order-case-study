package com.jnkziaa.customerordercasestudy.dto;

import com.jnkziaa.customerordercasestudy.entity.ShoppingCartInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String orderDescription;
    private List<ShoppingCartInfo> cartItems;
    private String customerEmail;
    private String customerUsername;
}
