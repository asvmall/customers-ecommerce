package com.example.asvmall_v1.controller;

import com.example.asvmall_v1.entity.ProductEntity;
import com.example.asvmall_v1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }
}
