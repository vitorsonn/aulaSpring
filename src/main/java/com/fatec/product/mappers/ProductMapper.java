package com.fatec.product.mappers;

import com.fatec.product.dto.ProductRequestDTO;
import com.fatec.product.dto.ProductResponseDTO;
import com.fatec.product.entities.Product;

public class ProductMapper {

    public static ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }

    public static Product toEntity(ProductRequestDTO req) {
        Product p = new Product();
        p.setDescription(req.description());
        p.setName(req.name());
        p.setPrice(req.price());
        return p;
    }

}
