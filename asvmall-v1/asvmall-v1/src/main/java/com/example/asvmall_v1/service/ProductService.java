package com.example.asvmall_v1.service;

import com.example.asvmall_v1.entity.ProductEntity;
import com.example.asvmall_v1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
