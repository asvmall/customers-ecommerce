package com.asvmall.asvmall.Controller;


import com.asvmall.asvmall.entities.Banners;
import com.asvmall.asvmall.service.BannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/banners")
public class BannersController {

    @Autowired
    private BannersService bannersService;

    @PostMapping
    public ResponseEntity<Banners> createBanner(@RequestBody Banners banner) {
        return ResponseEntity.ok(bannersService.createBanner(banner));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banners> getBannerById(@PathVariable int id) {
        Banners b = bannersService.getBannerById(id);
        if (b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);
    }

    @GetMapping
    public ResponseEntity<List<Banners>> getAllBanners() {
        return ResponseEntity.ok(bannersService.getAllBanners());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banners> updateBanner(@PathVariable int id, @RequestBody Banners banner) {
        Banners updated = bannersService.updateBanner(id, banner);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanner(@PathVariable int id) {
        bannersService.deleteBanner(id);
        return ResponseEntity.noContent().build();
    }
}

