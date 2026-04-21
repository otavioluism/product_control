package com.otavioluism.projeto_spring_boot.service;

import com.otavioluism.projeto_spring_boot.entity.ProductEntity;
import com.otavioluism.projeto_spring_boot.exceptions.ProductNotFoundException;
import com.otavioluism.projeto_spring_boot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAll() {
        return this.productRepository.findAll();
    }

    public ProductEntity getById(Long Id) {
        return this.productRepository.findById(Id)
                .orElseThrow(() -> new ProductNotFoundException(Id));
    }

    public ProductEntity save(ProductEntity product) {
        return this.productRepository.save(product);
    }

    public void deleteProduct(Long Id) {

        if (!productRepository.existsById(Id)) {
            throw new ProductNotFoundException(Id);
        }

        this.productRepository.deleteById(Id);
    }


}
