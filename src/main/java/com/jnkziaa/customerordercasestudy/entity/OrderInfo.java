package com.jnkziaa.customerordercasestudy.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_INFO")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oID;


    private String orderDescription;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = CartItemsInfo.class)
    @JoinColumn(name = "shoppingCardID", referencedColumnName = "oID")
    private List<CartItemsInfo> cartItems;

    private double totalCostOfCart;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_ID", referencedColumnName = "cID")
    private CustomerInfo customer;


    public OrderInfo(String orderDescription,CustomerInfo customer , double totalCostOfCart, List<CartItemsInfo> cartItems) {
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
        this.totalCostOfCart = totalCostOfCart;
        this.customer = customer;
    }
}



