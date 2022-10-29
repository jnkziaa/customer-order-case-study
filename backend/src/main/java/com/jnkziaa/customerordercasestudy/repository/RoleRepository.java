package com.jnkziaa.customerordercasestudy.repository;


import com.jnkziaa.customerordercasestudy.entity.ERole;
import com.jnkziaa.customerordercasestudy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}