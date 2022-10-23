package com.jnkziaa.customerordercasestudy.service;


import com.jnkziaa.customerordercasestudy.entity.CartItemsInfo;
import com.jnkziaa.customerordercasestudy.entity.OrderInfo;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
//import com.jnkziaa.customerordercasestudy.entity.ShoppingCartInfo;
import com.jnkziaa.customerordercasestudy.repository.OrderInfoRepository;
import com.jnkziaa.customerordercasestudy.repository.ProductInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerPurchaseService {
    private OrderInfoRepository orderInfoRepository;
    private ProductInfoRepository productInfoRepository;

    public CustomerPurchaseService(OrderInfoRepository orderInfoRepository, ProductInfoRepository productInfoRepository) {
        this.orderInfoRepository = orderInfoRepository;
        this.productInfoRepository = productInfoRepository;
    }

    public OrderInfo getOrderDetails(Long orderID){
        Optional<OrderInfo> orderInfo = this.orderInfoRepository.findById(orderID);
        return orderInfo.isPresent() ? orderInfo.get() : null;
    }

    public double getShoppingCartTotal(List<CartItemsInfo> cartItemsInfoList){

        double totalCartAmount = 0.0;
        double singleCartAmount;
        int availableQuantity = 0;

        System.out.println("SIZE OF SHOPPING LIST IS " + cartItemsInfoList.size());
        for (CartItemsInfo cart : cartItemsInfoList){
            System.out.println("CART INFO IS : " + cart);
            String productName = cart.getProductName();

            //Optional<ProductInfo> productInfoIDs = productInfoRepository.findById(productID);
            Optional<ProductInfo> productInfoIDs = Optional.ofNullable(productInfoRepository.findByProductName(productName));
            System.out.println("PRODUCT INFORMATIONS ARE :" + productInfoIDs);

            if(productInfoIDs.isPresent()){

                ProductInfo productInfo1 = productInfoIDs.get();
                //System.out.println("PRODUCT1 ARE :" + productInfo1);

                System.out.println("AVAILABLE QUANTITY: " + productInfo1.getProductAvailableQuantity() + " CART QUANTITY : " + cart.getProductQuantityAmount());
                if(productInfo1.getProductAvailableQuantity() < cart.getProductQuantityAmount()){

                    singleCartAmount = productInfo1.getProductPrice() * productInfo1.getProductAvailableQuantity();

                    cart.setProductQuantityAmount(productInfo1.getProductAvailableQuantity());
                }else{

                    singleCartAmount = cart.getProductQuantityAmount() * productInfo1.getProductPrice();

                    availableQuantity = productInfo1.getProductAvailableQuantity() - cart.getProductQuantityAmount();
                }

                System.out.println("CURRENT TOTAL ARE " + singleCartAmount + " " + totalCartAmount);
                totalCartAmount = totalCartAmount + singleCartAmount;
                productInfo1.setProductAvailableQuantity(availableQuantity);
                availableQuantity = 0;
                cart.setProductID(productInfo1.getPID());
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
