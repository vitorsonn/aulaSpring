package com.fatec.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.product.entities.Product;
import com.fatec.product.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);

        }

        else {
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }

    public Product save(Product product){
        return repository.save(product);
    }


    public void update(Product product, Long id){
        Product p = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não cadastrado"));

        p.setDescription(product.getDescription());
        p.setName(product.getName());
        p.setPrice(product.getPrice());

        repository.save(p);
    }

}
