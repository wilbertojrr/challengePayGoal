package com.challenge.paygoal.mapper;

import com.challenge.paygoal.dto.ProductDto;
import com.challenge.paygoal.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto toDTO(ProductEntity product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto) {
        ProductEntity product = new ProductEntity();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }
}
