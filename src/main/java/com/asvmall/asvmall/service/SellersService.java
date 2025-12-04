package com.asvmall.asvmall.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Sellers;
import com.asvmall.asvmall.repository.SellersRepository;

import java.util.List;

@Service
public class SellersService {

    @Autowired
    private SellersRepository sellersRepository;

    public Sellers createSeller(Sellers seller) {
        return sellersRepository.save(seller);
    }

    public Sellers getSellerById(int id) {
        return sellersRepository.findById(id).orElse(null);
    }

    public List<Sellers> getAllSellers() {
        return sellersRepository.findAll();
    }

    public Sellers updateSeller(int id, Sellers seller) {
        Sellers existing = sellersRepository.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setUser_id(seller.getUser_id());
        existing.setShop_name(seller.getShop_name());
        existing.setGst_number(seller.getGst_number());
        existing.setStatus(seller.getStatus());
        existing.setCreated_on(seller.getCreated_on());

        return sellersRepository.save(existing);
    }

    public void deleteSeller(int id) {
        sellersRepository.deleteById(id);
    }
}

