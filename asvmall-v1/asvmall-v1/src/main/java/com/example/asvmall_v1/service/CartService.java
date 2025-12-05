package com.example.asvmall_v1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asvmall_v1.entity.CartEntity;
import com.example.asvmall_v1.entity.ProductEntity;
import com.example.asvmall_v1.repository.CartRepository;
import com.example.asvmall_v1.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartEntity addToCart(int userId, int product_id, int quantity) {

        System.out.println("➡ Update Cart => userId: " + userId +
                ", productId: " + product_id +
                ", quantity: " + quantity);

        CartEntity existing = cartRepository.findByUserIdAndProductProductId(userId, product_id);
        if (existing != null) {
            existing.setQuantity(quantity);
            return cartRepository.save(existing);
        }

        ProductEntity product = productRepository.findById(product_id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        CartEntity cart = new CartEntity();
        cart.setUserId(userId);
        cart.setProduct(product);
        cart.setQuantity(quantity);

        return cartRepository.save(cart);
    }

    public List<CartEntity> getCartByUser(int userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeFromCart(int cartId) {
        cartRepository.deleteById(cartId);
    }
}
