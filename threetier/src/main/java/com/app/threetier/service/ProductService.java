package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public List<ProductVO> getProducts();
    public void addProduct(ProductVO productVO);
}
