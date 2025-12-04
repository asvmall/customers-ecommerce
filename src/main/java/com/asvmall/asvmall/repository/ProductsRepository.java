package com.asvmall.asvmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asvmall.asvmall.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
