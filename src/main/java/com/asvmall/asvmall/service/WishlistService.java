package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Wishlist;
import com.asvmall.asvmall.repository.WishlistRepository;


import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist addWishlistItem(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public Wishlist getWishlistItem(int id) {
        return wishlistRepository.findById(id).orElse(null);
    }

    public Optional<Wishlist> getWishlistByUser(int userId) {
        return wishlistRepository.findById(userId);
    }

    public void removeWishlistItem(int id) {
        wishlistRepository.deleteById(id);
    }
}

