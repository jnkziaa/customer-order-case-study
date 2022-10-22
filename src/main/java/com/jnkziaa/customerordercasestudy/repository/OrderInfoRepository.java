package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;


public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

}
