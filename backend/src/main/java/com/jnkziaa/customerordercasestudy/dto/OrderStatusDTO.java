package com.jnkziaa.customerordercasestudy.dto;

import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import com.jnkziaa.customerordercasestudy.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDTO {
    private OrderStatus orderStatus;
    private String dateOrdered;
    private String expectedDeliveryDate;
    private Long productID;
    private String productName;
    private double totalCost;
    private Long customerID;
    private ProductInfo cartItems;
}