package com.asvmall.asvmall.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;

    private int products_id;
    private int user_id;
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @CreationTimestamp
    private LocalDateTime created_on;

    public Reviews() {}

    // Getters & Setters
    public int getReview_id() { return review_id; }
    public void setReview_id(int review_id) { this.review_id = review_id; }

    public int getProducts_id() { return products_id; }
    public void setProducts_id(int products_id) { this.products_id = products_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDateTime getCreated_on() { return created_on; }
    public void setCreated_on(LocalDateTime created_on) { this.created_on = created_on; }

	public Reviews(int review_id, int products_id, int user_id, int rating, String comment, LocalDateTime created_on) {
		super();
		this.review_id = review_id;
		this.products_id = products_id;
		this.user_id = user_id;
		this.rating = rating;
		this.comment = comment;
		this.created_on = created_on;
	}
    
}

