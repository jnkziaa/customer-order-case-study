package com.jnkziaa.customerordercasestudy.dto;


import com.jnkziaa.customerordercasestudy.entity.CompleteOrderArchivedInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToArchivedRequest {
    public CompleteOrderArchivedInfo completeOrderArchivedInfo;
}
