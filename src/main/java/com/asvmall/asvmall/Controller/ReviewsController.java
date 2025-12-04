package com.asvmall.asvmall.Controller;


import com.asvmall.asvmall.entities.Reviews;
import com.asvmall.asvmall.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Reviews review) {
        return ResponseEntity.ok(reviewsService.createReview(review));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable int id) {
        Reviews r = reviewsService.getReviewById(id);
        if (r == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(r);
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.getAllReviews());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reviews> updateReview(@PathVariable int id, @RequestBody Reviews review) {
        Reviews updated = reviewsService.updateReview(id, review);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable int id) {
        reviewsService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}

