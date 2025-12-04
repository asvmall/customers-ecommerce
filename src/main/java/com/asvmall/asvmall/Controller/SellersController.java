package com.asvmall.asvmall.Controller;

import com.asvmall.asvmall.entities.Sellers;
import com.asvmall.asvmall.service.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellersController {

    @Autowired
    private SellersService sellersService;

    @PostMapping
    public ResponseEntity<Sellers> createSeller(@RequestBody Sellers seller) {
        return ResponseEntity.ok(sellersService.createSeller(seller));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sellers> getSellerById(@PathVariable int id) {
        Sellers s = sellersService.getSellerById(id);
        if (s == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<List<Sellers>> getAllSellers() {
        return ResponseEntity.ok(sellersService.getAllSellers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sellers> updateSeller(@PathVariable int id, @RequestBody Sellers seller) {
        Sellers updated = sellersService.updateSeller(id, seller);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable int id) {
        sellersService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}

