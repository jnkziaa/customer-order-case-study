package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.CartItemsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsInfoRepository extends JpaRepository<CartItemsInfo, Long> {
}
