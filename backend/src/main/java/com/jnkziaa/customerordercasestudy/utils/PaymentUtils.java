package com.jnkziaa.customerordercasestudy.utils;


import com.jnkziaa.customerordercasestudy.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 8000.0);
        paymentMap.put("acc4", 7500.0);
        paymentMap.put("acc5", 4700.0);
    }

    public static boolean validateCreditLimits(String accNo, double paidAmount){
        if(paidAmount > paymentMap.get(accNo)){
            throw new InsufficientAmountException("insufficient fund...");
        }
        else{
            return true;
        }
    }
}