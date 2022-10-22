package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.ShoppingCartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ShoppingCartInfoRepository extends JpaRepository<ShoppingCartInfo, String> {

}
