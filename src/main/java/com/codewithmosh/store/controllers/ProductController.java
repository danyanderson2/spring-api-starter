package com.codewithmosh.store.controllers;

import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @GetMapping()
    public Iterable<Product> getAllProducts(){
        System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        var product = productRepository.findById(id).orElse(null);
        if(product == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


}
