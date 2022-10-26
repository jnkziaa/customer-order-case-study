package com.jnkziaa.customerordercasestudy.service;


/*
import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseAcknowledgement;
import com.jnkziaa.customerordercasestudy.dto.CustomerPurchaseRequest;
import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import com.jnkziaa.customerordercasestudy.entity.PaymentInfo;
import com.jnkziaa.customerordercasestudy.repository.CustomerInfoRepository;
import com.jnkziaa.customerordercasestudy.repository.PaymentInfoRepository;
import com.jnkziaa.customerordercasestudy.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CustomerPurchaseService {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public CustomerPurchaseAcknowledgement customerPurchase(CustomerPurchaseRequest request){
        CustomerInfo customerInfo = request.getCustomerInfo();
        customerInfoRepository.save(customerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimits(paymentInfo.getAccountNo(), customerInfo.getCurrentBalance());

        paymentInfo.setCustomerId(customerInfo.getCId());
        paymentInfo.setAmount(customerInfo.getCurrentBalance());
        paymentInfoRepository.save(paymentInfo);

        return new CustomerPurchaseAcknowledgement("Success", customerInfo.getCurrentBalance(), UUID.randomUUID().toString().split("-")[0], customerInfo);


    }
}

 */