package com.example.asvmall_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.asvmall_v1.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
