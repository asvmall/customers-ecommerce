package com.example.asvmall_v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.asvmall_v1.entity.ProductImageEntity;

public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Integer> {
    List<ProductImageEntity> findByProductProductId(int productId);
}
