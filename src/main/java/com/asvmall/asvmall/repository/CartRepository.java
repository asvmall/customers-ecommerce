package com.asvmall.asvmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asvmall.asvmall.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}

