package com.mahesh.asv_mall.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="wishlist")
public class WishListEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wishlist_id")
	private Integer wishlist_id;
	@Column(name="user_id")
	private Integer user_id;
	@Column(name="added_at")
	private LocalDate added_at;
	@ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductEntity productEntity;
	public WishListEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishListEntity(Integer wishlist_id, Integer user_id, LocalDate added_at, ProductEntity productEntity) {
		super();
		this.wishlist_id = wishlist_id;
		this.user_id = user_id;
		this.added_at = added_at;
		this.productEntity = productEntity;
	}
	public Integer getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(Integer wishlist_id) {
		this.wishlist_id = wishlist_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public LocalDate getAdded_at() {
		return added_at;
	}
	public void setAdded_at(LocalDate added_at) {
		this.added_at = added_at;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

}
