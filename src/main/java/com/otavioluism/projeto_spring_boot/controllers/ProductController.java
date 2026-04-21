package com.otavioluism.projeto_spring_boot.controllers;

import com.otavioluism.projeto_spring_boot.entity.ProductEntity;
import com.otavioluism.projeto_spring_boot.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.productService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
        ProductEntity product_created = this.productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product_created);
    }


}
