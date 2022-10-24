package com.jnkziaa.customerordercasestudy.service;


import com.jnkziaa.customerordercasestudy.dto.AddToArchivedRequest;
import com.jnkziaa.customerordercasestudy.entity.CompleteOrderArchivedInfo;
import com.jnkziaa.customerordercasestudy.repository.CompleteOrderArchivedInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArchivedOrderService {

    @Autowired
    private CompleteOrderArchivedInfoRepository completeOrderArchivedInfoRepository;

    public ArchivedOrderService(CompleteOrderArchivedInfoRepository completeOrderArchivedInfoRepository) {
        this.completeOrderArchivedInfoRepository = completeOrderArchivedInfoRepository;
    }

    public List<CompleteOrderArchivedInfo> completeOrderArchivedInfoList(){
        return this.completeOrderArchivedInfoRepository.findAll();
    }

    @Transactional
    public void saveArchivedItemsInfo(CompleteOrderArchivedInfo completeOrderArchivedInfo) {
        completeOrderArchivedInfoRepository.save(completeOrderArchivedInfo);
    }
}
