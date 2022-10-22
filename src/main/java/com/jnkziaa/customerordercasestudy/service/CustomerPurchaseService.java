package com.jnkziaa.customerordercasestudy.service;


import com.jnkziaa.customerordercasestudy.entity.OrderInfo;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import com.jnkziaa.customerordercasestudy.entity.ShoppingCartInfo;
import com.jnkziaa.customerordercasestudy.repository.OrderInfoRepository;
import com.jnkziaa.customerordercasestudy.repository.ProductInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerPurchaseService {
    private OrderInfoRepository orderInfoRepository;
    private ProductInfoRepository productInfoRepository;

    public OrderInfo getOrderDetails(Long orderID){
        Optional<OrderInfo> orderInfo = this.orderInfoRepository.findById(orderID);
        return orderInfo.isPresent() ? orderInfo.get() : null;
    }

    public double getShoppingCartTotal(List<ShoppingCartInfo> shoppingCartInfoList){
        double totalCartAmount = 0.0;
        double singleCartAmount = 0.0;
        int availableQuantity = 0;

        for (ShoppingCartInfo cart : shoppingCartInfoList){
            Long productID = cart.getProductID();
            Optional<ProductInfo> productInfo = productInfoRepository.findById(productID);

            if(productInfo.isPresent()){
                ProductInfo productInfo1 = productInfo.get();
                if(productInfo1.getProductAvailableQuantity() < cart.getProductCount()){
                    singleCartAmount = productInfo1.getProductPrice() * productInfo1.getProductAvailableQuantity();
                    cart.setProductCount(productInfo1.getProductAvailableQuantity());
                }else{
                    singleCartAmount = cart.getProductCount() * productInfo1.getProductPrice();
                    availableQuantity = productInfo1.getProductAvailableQuantity() - cart.getProductCount();
                }

                totalCartAmount = totalCartAmount + singleCartAmount;
                productInfo1.setProductAvailableQuantity(availableQuantity);
                availableQuantity = 0;
                cart.setProductName(productInfo1.getProductName());
                cart.setTotalCost(singleCartAmount);
                productInfoRepository.save(productInfo1);
            }
        }

        return totalCartAmount;
    }

    public OrderInfo saveOrder(OrderInfo orderInfo){
        return orderInfoRepository.save(orderInfo);
    }
}
