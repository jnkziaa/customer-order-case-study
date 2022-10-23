package com.jnkziaa.customerordercasestudy.service;

import com.jnkziaa.customerordercasestudy.dto.AddToCartRequest;
import com.jnkziaa.customerordercasestudy.entity.CartItemsInfo;
import com.jnkziaa.customerordercasestudy.repository.CartItemsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ShowCartItemsService {

    @Autowired
    private CartItemsInfoRepository cartItemsInfoRepository;

    public ShowCartItemsService(CartItemsInfoRepository cartItemsInfoRepository) {
        this.cartItemsInfoRepository = cartItemsInfoRepository;
    }

    public List<CartItemsInfo> cartItemsInfoList(){
        return this.cartItemsInfoRepository.findAll();
    }

    @Transactional
    public void saveCartItemsInfo(AddToCartRequest request) {
        CartItemsInfo cartItemsInfo = request.getCartItemsInfo();
        cartItemsInfoRepository.save(cartItemsInfo);
    }
}
