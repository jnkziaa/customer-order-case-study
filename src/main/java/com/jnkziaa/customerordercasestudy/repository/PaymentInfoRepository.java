package com.jnkziaa.customerordercasestudy.repository;



import com.jnkziaa.customerordercasestudy.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}