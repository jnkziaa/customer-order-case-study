package com.jnkziaa.customerordercasestudy.dto;

import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPurchaseAcknowledgement {
    private String status;
    private double actualCost;
    private String pnrNo;
    private CustomerInfo customerInfo;
}

