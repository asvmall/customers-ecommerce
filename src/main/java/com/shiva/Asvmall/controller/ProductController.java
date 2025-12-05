package com.shiva.Asvmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.Asvmall.entity.ProductEntity;
import com.shiva.Asvmall.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products-categories/{id}")

    public List<ProductEntity> getProductsByCategory(@PathVariable int id) {
        return productService.getProductsByCategoryId(id);
    }
}
