package com.shiva.Asvmall.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer product_id;
	@Column(name="seller_id")
	private Integer seller_id;
	@Column(name="category_id")
	private Integer category_id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private Double price;
	@Column(name="discount")
	private Double discount;
	@Column(name="stock")
	private Integer stock;
	@Column(name="sku")
	private String sku;
	@Column(name="status")
	private String status;
	@Column(name="created_at")
	private LocalDateTime created_at;
	@Column(name="updated_at")
	private LocalDateTime updated_at;
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductEntity(Integer product_id, Integer seller_id, Integer category_id, String name, String description,
			Double price, Double discount, Integer stock, String sku, String status, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		this.product_id = product_id;
		this.seller_id = seller_id;
		this.category_id = category_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.stock = stock;
		this.sku = sku;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	

}
