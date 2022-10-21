package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.dto.Product;
import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional
    public void saveProduct(Product product){
        String sql = "INSERT INTO PRODUCT VALUES (?,?)";
        Object[] args = {product.getIdPRODUCT(), product.getPROD_NAME()};
        jdbcTemplate.update(sql, args);
    }*/

}
