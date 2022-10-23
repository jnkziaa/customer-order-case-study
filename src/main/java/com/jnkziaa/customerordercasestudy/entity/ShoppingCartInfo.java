/*package com.jnkziaa.customerordercasestudy.entity;


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
@Table(name = "SHOPPINGCART_INFO")
public class ShoppingCartInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String oID;

    private Long productID;
    private String productName;
    private int productQuantityAmount;
    private double totalCost;

}
*
 */
