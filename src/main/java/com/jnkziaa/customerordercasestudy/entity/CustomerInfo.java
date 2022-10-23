package com.jnkziaa.customerordercasestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cID;


    private String username;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    private double currentBalance;


    public CustomerInfo(String username, String email) {
        this.username = username;
        this.email = email;
        this.currentBalance = 2500.0;
    }


}


