package com.jnkziaa.customerordercasestudy.service;

import com.jnkziaa.customerordercasestudy.dto.AddToCartRequest;
import com.jnkziaa.customerordercasestudy.dto.UserAdditionRequest;
import com.jnkziaa.customerordercasestudy.entity.CartItemsInfo;
import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import com.jnkziaa.customerordercasestudy.repository.CartItemsInfoRepository;
import com.jnkziaa.customerordercasestudy.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class CustomerRegistrationService {

    private CustomerInfoRepository customerInfoRepository;

    public CustomerRegistrationService(CustomerInfoRepository customerInfoRepository) {

        this.customerInfoRepository = customerInfoRepository;
    }

    public List<CustomerInfo> customerInfoList(){
        return this.customerInfoRepository.findAll();
    }

    @Transactional
    public void saveCustomerInfo(UserAdditionRequest request){
        CustomerInfo customerInfo = request.getCustomerInfo();
        customerInfoRepository.save(customerInfo);
    }
}

