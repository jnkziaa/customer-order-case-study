package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {


    public CustomerInfo getCustomerInfoByEmailAndUsername(String email, String username);
}