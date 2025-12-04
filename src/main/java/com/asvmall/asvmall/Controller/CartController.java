package com.asvmall.asvmall.Controller;


import com.asvmall.asvmall.entities.Cart;
import com.asvmall.asvmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.addToCart(cart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable int id) {
        Cart c = cartService.getCartById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCartItems() {
        return ResponseEntity.ok(cartService.getAllCartItems());
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int id) {
        cartService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}

