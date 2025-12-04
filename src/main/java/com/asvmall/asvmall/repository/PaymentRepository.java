package com.asvmall.asvmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asvmall.asvmall.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}

