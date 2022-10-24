package com.jnkziaa.customerordercasestudy.entity;

import com.jnkziaa.customerordercasestudy.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_STATUS_INFO")
public class OrderStatusInfo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String orderStatusID;

    private OrderStatus orderStatus;
    private String dateOrdered;
    private String expectedDeliveryDate;
    private Long productID;
    private String productName;
    private double totalCost;

    @JoinColumn(name = "customer_ID", referencedColumnName = "cID")
    private Long customerID;

    @ManyToOne
    @JoinColumn(name = "cart_items_p_id")
    private ProductInfo cartItems;
}
