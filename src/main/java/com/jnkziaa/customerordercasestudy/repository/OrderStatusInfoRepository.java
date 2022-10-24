package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.OrderStatusInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusInfoRepository extends JpaRepository<OrderStatusInfo, String> {
}
