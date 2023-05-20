package com.challenge.paygoal.service.implementation;

import com.challenge.paygoal.entity.ProductEntity;
import com.challenge.paygoal.exception.ParamNotFound;
import com.challenge.paygoal.repository.IProductRepository;
import com.challenge.paygoal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity product) {
        Optional<ProductEntity> presentProduct = productRepository.findByName(product.getName());
        if(presentProduct.isPresent()){
            throw new ParamNotFound("Product Name Exist, update or change name");
        }
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

    @Override
    public ProductEntity updateProduct(Long id, ProductEntity product) {
        Optional<ProductEntity> presentProduct = productRepository.findById(id);
        if(presentProduct.isEmpty()){
            throw new ParamNotFound("Product ID not found");
        }
        ProductEntity updatedProduct = presentProduct.get();
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());
        return productRepository.save(updatedProduct);
    }

    @Override
    public List<ProductEntity> getAllProductsSortedByPrice(String sorted) {
        return productRepository.findAll(Sort.by(Sort.Direction.fromString(sorted), "price"));
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ParamNotFound("Product Id not found");
        }
        productRepository.delete(product.get());
    }
}
