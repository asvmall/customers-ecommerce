package com.asvmall.asvmall.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvmall.asvmall.entities.Reviews;
import com.asvmall.asvmall.repository.ReviewsRepository;

import java.util.List;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    
    public Reviews createReview(Reviews review) {
        return reviewsRepository.save(review);
    }

    
    public Reviews getReviewById(int id) {
        return reviewsRepository.findById(id).orElse(null);
    }

    
    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    
    public Reviews updateReview(int id, Reviews review) {
        Reviews existing = reviewsRepository.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setProducts_id(review.getProducts_id());
        existing.setUser_id(review.getUser_id());
        existing.setRating(review.getRating());
        existing.setComment(review.getComment());
        existing.setCreated_on(review.getCreated_on());

        return reviewsRepository.save(existing);
    }

    
    public void deleteReview(int id) {
        reviewsRepository.deleteById(id);
    }
}

