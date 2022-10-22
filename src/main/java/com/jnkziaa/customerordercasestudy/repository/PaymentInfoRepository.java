package com.jnkziaa.customerordercasestudy.repository;



import com.jnkziaa.customerordercasestudy.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}