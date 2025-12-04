package com.asvmall.asvmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Cart;
import com.asvmall.asvmall.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    
    public Cart getCartById(int id) {
        return cartRepository.findById(id).orElse(null);
    }

    
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    

    
    public void deleteCartItem(int id) {
        cartRepository.deleteById(id);
    }
}

