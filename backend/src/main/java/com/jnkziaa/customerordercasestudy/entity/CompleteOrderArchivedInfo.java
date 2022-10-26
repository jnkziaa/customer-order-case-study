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
@Table(name = "archived_order_info")
public class CompleteOrderArchivedInfo{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String archivedOrderID;

    private Long productID;
    private String productName;

    @JoinColumn(name = "customer_ID", referencedColumnName = "custID")
    private Long custID;
    private int productQuantityAmount;
    private double totalCost;

    public CompleteOrderArchivedInfo(Long productID, String productName, Long cID, int productQuantityAmount, double totalCost) {
        this.productID = productID;
        this.productName = productName;
        this.custID = cID;
        this.productQuantityAmount = productQuantityAmount;
        this.totalCost = totalCost;
    }
}

