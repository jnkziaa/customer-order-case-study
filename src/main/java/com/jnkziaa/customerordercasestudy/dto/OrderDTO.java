package com.jnkziaa.customerordercasestudy.dto;

import com.jnkziaa.customerordercasestudy.controller.ShoppingCartRestController;
import com.jnkziaa.customerordercasestudy.entity.CartItemsInfo;
//import com.jnkziaa.customerordercasestudy.entity.ShoppingCartInfo;
import com.jnkziaa.customerordercasestudy.entity.CompleteOrderArchivedInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String orderDescription;
    private List<CompleteOrderArchivedInfo> cartItems;
    private double totalCostOfCart;
    private Long cID;
    private String customerEmail;
    private String customerUsername;

}
