package com.challenge.paygoal.service;

import com.challenge.paygoal.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductEntity createProduct(ProductEntity product);

    ProductEntity getProductById(Long id);

    ProductEntity getProductByName(String name);

    ProductEntity updateProduct(Long id, ProductEntity product);

    List<ProductEntity> getAllProductsSortedByPrice(String sorted);

    void deleteProduct(Long id);
}
