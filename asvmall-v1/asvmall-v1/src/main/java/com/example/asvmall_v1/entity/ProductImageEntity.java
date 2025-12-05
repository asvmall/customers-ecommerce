package com.example.asvmall_v1.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product_images")
public class ProductImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductEntity product;

    public ProductImageEntity() {}

    public ProductImageEntity(String imageUrl, ProductEntity product) {
        this.imageUrl = imageUrl;
        this.product = product;
    }

    public int getId() { return id; }
    public String getImageUrl() { return imageUrl; }
    public ProductEntity getProduct() { return product; }
}
