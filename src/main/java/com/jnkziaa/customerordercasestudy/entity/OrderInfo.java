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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oID;


    private String orderDescription;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_ID", referencedColumnName = "cID")
    private CustomerInfo customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingCartInfo.class)
    @JoinColumn(name = "shoppingCart_ID", referencedColumnName = "oID")
    private List<ShoppingCartInfo> cartItems;


    public OrderInfo(String orderDescription, CustomerInfo customer, List<ShoppingCartInfo> cartItems) {
        this.orderDescription = orderDescription;
        this.customer = customer;
        this.cartItems = cartItems;
    }
}



