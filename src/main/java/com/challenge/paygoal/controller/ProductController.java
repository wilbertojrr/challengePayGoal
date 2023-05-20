package com.challenge.paygoal.controller;

import com.challenge.paygoal.dto.ProductDto;
import com.challenge.paygoal.entity.ProductEntity;
import com.challenge.paygoal.mapper.ProductMapper;
import com.challenge.paygoal.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IProductService productService;
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

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDTO) {
        ProductEntity product = productMapper.toEntity(productDTO);
        ProductEntity updatedProduct = productService.updateProduct(id, product);
        ProductDto updatedProductDTO = productMapper.toDTO(updatedProduct);
        return ResponseEntity.ok(updatedProductDTO);
    }

    @GetMapping("/sortedPrice")
    public ResponseEntity<List<ProductDto>> getAllProductsSortedByPrice(@RequestParam(required = false, defaultValue = "ASC") String sorted) {
        List<ProductEntity> products = productService.getAllProductsSortedByPrice(sorted);
        List<ProductDto> productDTOs = products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
