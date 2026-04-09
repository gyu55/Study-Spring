package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    void getProductsTest() {
        log.info("productService : {}", productService.getProducts());
    }

    @Test
    void addProductsTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("test");
        productVO.setProductPrice(10000L);
        productVO.setProductStock(5L);
        productVO.setProductBrand("testBrand");
        productService.addProduct(productVO);
    }
}
