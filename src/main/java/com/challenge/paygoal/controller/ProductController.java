package com.challenge.paygoal.controller;

import com.challenge.paygoal.dto.ProductDto;
import com.challenge.paygoal.entity.ProductEntity;
import com.challenge.paygoal.mapper.ProductMapper;
import com.challenge.paygoal.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IproductService productService;
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDTO) {
        ProductEntity product = productMapper.toEntity(productDTO);
        ProductEntity createdProduct = productService.createProduct(product);
        ProductDto createdProductDTO = productMapper.toDTO(createdProduct);
        return ResponseEntity.ok(createdProductDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductEntity product = productService.getProductById(id);
        ProductDto productDTO = productMapper.toDTO(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable String name) {
        ProductEntity product = productService.getProductByName(name);
        ProductDto productDTO = productMapper.toDTO(product);
        return ResponseEntity.ok(productDTO);
    }
}
