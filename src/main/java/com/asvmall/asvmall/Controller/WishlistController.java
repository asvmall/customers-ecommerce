package com.asvmall.asvmall.Controller;

import com.asvmall.asvmall.entities.Wishlist;
import com.asvmall.asvmall.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public ResponseEntity<Wishlist> addWishlistItem(@RequestBody Wishlist wishlist) {
        return ResponseEntity.ok(wishlistService.addWishlistItem(wishlist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistItem(@PathVariable int id) {
        Wishlist item = wishlistService.getWishlistItem(id);
        if (item == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(item);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<Wishlist>> getWishlistByUser(@PathVariable int userId) {
        return ResponseEntity.ok(wishlistService.getWishlistByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeWishlistItem(@PathVariable int id) {
        wishlistService.removeWishlistItem(id);
        return ResponseEntity.noContent().build();
    }
}
