package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Orders;
import com.asvmall.asvmall.repository.OrdersRepository;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders getOrderById(int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders updateOrderStatus(int id, String status) {
        Orders existing = ordersRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setStatus(status);

        return ordersRepository.save(existing);
    }

    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }
}
