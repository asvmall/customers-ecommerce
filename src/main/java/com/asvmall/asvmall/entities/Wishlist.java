package com.asvmall.asvmall.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlist_id;

    private int user_id;
    private int products_id;

    public Wishlist() {}

    // Getters & Setters
    public int getWishlist_id() { return wishlist_id; }
    public void setWishlist_id(int wishlist_id) { this.wishlist_id = wishlist_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getProducts_id() { return products_id; }
    public void setProducts_id(int products_id) { this.products_id = products_id; }
}

