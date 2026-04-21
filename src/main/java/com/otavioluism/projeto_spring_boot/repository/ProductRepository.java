package com.otavioluism.projeto_spring_boot.repository;

import com.otavioluism.projeto_spring_boot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
