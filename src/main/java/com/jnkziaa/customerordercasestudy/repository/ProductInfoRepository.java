package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


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
