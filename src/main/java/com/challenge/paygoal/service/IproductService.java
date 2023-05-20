package com.challenge.paygoal.service;

import com.challenge.paygoal.entity.ProductEntity;

public interface IproductService {
    ProductEntity createProduct(ProductEntity product);

    ProductEntity getProductById(Long id);

    ProductEntity getProductByName(String name);
}
