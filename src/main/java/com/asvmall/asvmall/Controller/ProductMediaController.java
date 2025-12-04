package com.asvmall.asvmall.Controller;


import com.asvmall.asvmall.entities.ProductMedia;
import com.asvmall.asvmall.service.ProductMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/media")
public class ProductMediaController {

    @Autowired
    private ProductMediaService productMediaService;

    @PostMapping
    public ResponseEntity<ProductMedia> createMedia(@RequestBody ProductMedia media) {
        return ResponseEntity.ok(productMediaService.createMedia(media));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductMedia> getMediaById(@PathVariable int id) {
        ProductMedia m = productMediaService.getMediaById(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @GetMapping
    public ResponseEntity<List<ProductMedia>> getAllMedia() {
        return ResponseEntity.ok(productMediaService.getAllMedia());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductMedia> updateMedia(@PathVariable int id, @RequestBody ProductMedia media) {
        ProductMedia updated = productMediaService.updateMedia(id, media);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable int id) {
        productMediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }
}

