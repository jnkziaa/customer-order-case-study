package com.jnkziaa.customerordercasestudy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderDTO {
    private double amount;
    private int invoiceNumber;
    private String date;
    private String orderDescription;
    private Long orderID;
}
