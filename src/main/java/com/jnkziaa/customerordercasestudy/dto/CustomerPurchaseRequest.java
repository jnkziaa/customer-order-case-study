package com.jnkziaa.customerordercasestudy.dto;


import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import com.jnkziaa.customerordercasestudy.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPurchaseRequest {
    private CustomerInfo customerInfo;
    private PaymentInfo paymentInfo;
}