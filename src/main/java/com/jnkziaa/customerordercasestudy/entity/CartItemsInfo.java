package com.jnkziaa.customerordercasestudy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CART_ITEMS_INFO")
public class CartItemsInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String cartItemID;

    private Long productID;
    private String productName;
    private int productQuantityAmount;
    private double totalCost;
}
