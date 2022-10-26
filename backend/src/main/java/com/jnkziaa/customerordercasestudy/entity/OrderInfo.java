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


    private String invoiceNumber;
    private double totalCostOfCart;
    private String orderDate;
    private String orderDescription;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = CompleteOrderArchivedInfo.class)
    @JoinColumn(name = "shoppingCartID", referencedColumnName = "oID")
    private List<CompleteOrderArchivedInfo> cartItems;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customerOrder_ID", referencedColumnName = "cID")
    private CustomerInfo customer;


    public OrderInfo(String invoiceNumber, double totalCostOfCart, String orderDate, String orderDescription, List<CompleteOrderArchivedInfo> cartItems, CustomerInfo customer) {
        this.invoiceNumber = invoiceNumber;
        this.totalCostOfCart = totalCostOfCart;
        this.orderDate = orderDate;
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
        this.customer = customer;
    }
}



