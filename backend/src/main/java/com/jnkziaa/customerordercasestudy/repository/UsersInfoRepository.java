package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface UsersInfoRepository extends JpaRepository<UsersInfo, Long> {
    public Optional<UsersInfo> findUsersInfoByUsername(String username);
    public Boolean existsByUsername(String username);
    public Boolean existsByUserEmail(String email);
}
