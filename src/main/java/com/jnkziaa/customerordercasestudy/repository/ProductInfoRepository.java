package com.jnkziaa.customerordercasestudy.repository;

import com.jnkziaa.customerordercasestudy.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    //public ProductInfo getProductInfoByPID(Long productID);
    public ProductInfo findByProductName(String productName);
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
