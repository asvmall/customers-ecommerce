package com.asvmall.asvmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.asvmall.asvmall.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}

