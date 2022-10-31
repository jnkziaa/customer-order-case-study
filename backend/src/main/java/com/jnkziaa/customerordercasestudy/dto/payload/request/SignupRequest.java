package com.jnkziaa.customerordercasestudy.dto;


import lombok.Data;


import java.util.Set;

@Data
public class SignupRequest {
    private String username;
    private String email;
    private String password;

    private String city;
    private String stateFrom;
    private double currentBalance;

    private Set<String> role;
}