package com.asvmall.asvmall.Controller;

import com.asvmall.asvmall.entities.Categories;
import com.asvmall.asvmall.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public ResponseEntity<Categories> createCategory(@RequestBody Categories category) {
        return ResponseEntity.ok(categoriesService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable int id) {
        Categories c = categoriesService.getCategoryById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        return ResponseEntity.ok(categoriesService.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable int id, @RequestBody Categories category) {
        Categories updated = categoriesService.updateCategory(id, category);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoriesService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
