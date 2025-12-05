package com.example.asvmall_v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.asvmall_v1.entity.CartEntity;
import com.example.asvmall_v1.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/{productId}/{quantity}")
    public CartEntity addToCart(@PathVariable int userId,
                                @PathVariable int productId,
                                @PathVariable int quantity) {
    	
        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartEntity> getCart(@PathVariable int userId) {
        return cartService.getCartByUser(userId);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable int cartId) {
        cartService.removeFromCart(cartId);
        return ResponseEntity.noContent().build(); 
    }
}
