package com.example.asvmall_v1.entity;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="name")
    private String name;

    @Column(name="category")
    private String category;

    @Column(name="image_url")
    private String image_url;

    @Column(name="price")
    private double price;

    @Column(name="stock_quantity")
    private int stock_quantity;

    @Column(name="description")
    private String description;

    @Column(name="offer_percentage")
    private int offerPercentage;

    @Transient
    private double offerPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProductImageEntity> images;

    public List<ProductImageEntity> getImages() {
        return images;
    }

    public ProductEntity() {}

    public ProductEntity(int product_id, String name, String category, String image_url,
                         double price, int stock_quantity, String description, int offer_percentage) {
        this.productId = product_id;
        this.name = name;
        this.category = category;
        this.image_url = image_url;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.description = description;
        this.offerPercentage = offer_percentage;
    }

    public int getProduct_id() { return productId; }
    public void setProduct_id(int product_id) { this.productId = product_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getImage_url() { return image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock_quantity() { return stock_quantity; }
    public void setStock_quantity(int stock_quantity) { this.stock_quantity = stock_quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getOfferPercentage() { return offerPercentage; }
    public void setOfferPercentage(int offerPercentage) { this.offerPercentage = offerPercentage; }

    public double getOfferPrice() {
        if (offerPercentage <= 0) return price;
        return Math.round(price - (price * offerPercentage / 100));
    }
}
