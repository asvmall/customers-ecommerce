package com.asvmall.asvmall.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Products;
import com.asvmall.asvmall.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    
    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    
    public Products getProductById(int id) {
        return productsRepository.findById(id).orElse(null);
    }

    
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    
    public Products updateProduct(int id, Products product) {
        Products existing = productsRepository.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setCategory_id(product.getCategory_id());
        existing.setSeller_id(product.getSeller_id());
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setRecord_status(product.getRecord_status());

        return productsRepository.save(existing);
    }

    
    public void deleteProduct(int id) {
        productsRepository.deleteById(id);
    }
}

