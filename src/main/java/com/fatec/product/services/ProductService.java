package com.fatec.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.product.dto.ProductRequestDTO;
import com.fatec.product.dto.ProductResponseDTO;
import com.fatec.product.entities.Product;
import com.fatec.product.mappers.ProductMapper;
import com.fatec.product.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> getProducts() {
        return repository.findAll().stream().map(ProductMapper::toDTO).toList();
    }

    public ProductResponseDTO findById(Long id) {
        return repository.findById(id).map(ProductMapper::toDTO).orElseThrow(() -> new EntityNotFoundException());
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

        }

        else {
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }

    public ProductResponseDTO save(ProductRequestDTO product) { // pega o DTO e converte para entity
        Product p = repository.save(ProductMapper.toEntity(product));// salva a entidade no banco
        return ProductMapper.toDTO(p); // retorna o DTO
    }

    public void update(ProductRequestDTO product, Long id) {
        Product p = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não cadastrado"));

        p.setDescription(product.description());
        p.setName(product.name());
        p.setPrice(product.price());

        repository.save(p);
    }

}
