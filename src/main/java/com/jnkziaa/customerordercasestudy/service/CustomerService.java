package com.jnkziaa.customerordercasestudy.service;

import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import com.jnkziaa.customerordercasestudy.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    public CustomerService(CustomerInfoRepository customerInfoRepository){
        this.customerInfoRepository = customerInfoRepository;
    }

    public CustomerInfo saveCustomer(CustomerInfo customerInfo){
        return customerInfoRepository.save(customerInfo);
    }

    public Long isCustomerPresent(CustomerInfo customerInfo){
        CustomerInfo customerInfo1 = customerInfoRepository.getCustomerInfoByEmailAndUsername(customerInfo.getEmail(), customerInfo.getUsername());
        return customerInfo1 != null ? customerInfo1.getCID() : null;
    }
}
