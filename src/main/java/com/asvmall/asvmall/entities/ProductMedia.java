package com.asvmall.asvmall.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_media")
public class ProductMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int media_id;

    private int product_id;
    private String type;
    private String url;

    public ProductMedia() {}

    // Getters & Setters
    public int getMedia_id() { return media_id; }
    public void setMedia_id(int media_id) { this.media_id = media_id; }

    public int getProduct_id() { return product_id; }
    public void setProduct_id(int product_id) { this.product_id = product_id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

	public ProductMedia(int media_id, int product_id, String type, String url) {
		super();
		this.media_id = media_id;
		this.product_id = product_id;
		this.type = type;
		this.url = url;
	}
    
    
}

