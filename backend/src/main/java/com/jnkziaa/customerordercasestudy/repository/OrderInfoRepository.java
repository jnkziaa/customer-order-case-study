package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

}
