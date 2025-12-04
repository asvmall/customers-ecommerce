package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Payment;
import com.asvmall.asvmall.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment updatePaymentStatus(int id, String status) {
        Payment existing = paymentRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setStatus(status);
        return paymentRepository.save(existing);
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }
}

