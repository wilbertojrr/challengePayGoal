package com.challenge.paygoal.service.implementation;

import com.challenge.paygoal.entity.ProductEntity;
import com.challenge.paygoal.exception.ParamNotFound;
import com.challenge.paygoal.repository.IProductRepository;
import com.challenge.paygoal.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImp implements IproductService {
    @Autowired
    private IProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity product) {

        return productRepository.save(product);
    }

    @Override
    public ProductEntity getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ParamNotFound("Product Id not found");
        }
        return product.get();
    }

    @Override
    public ProductEntity getProductByName(String name) {
        Optional<ProductEntity> product = productRepository.findByName(name);
        if(product.isEmpty()){
            throw new ParamNotFound("Product Name not found");
        }
        return product.get();
    }
}
