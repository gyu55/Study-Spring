package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public List<ProductVO> getProducts() {
        return productDAO.findAll();
    }

    @Override
    public void addProduct(ProductVO productVO) {
        productDAO.insert(productVO);
    }

}
