package com.shiva.Asvmall.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class CategoriesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer category_id;
	@Column(name="name")
	private String name;
	@Column(name="parent_id")
	private Integer parent_id;
	@Column(name="icon")
	private String icon;
	@Column(name="created_at")
	private LocalDateTime created_at;
	public CategoriesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriesEntity(Integer category_id, String name, Integer parent_id, String icon,
			LocalDateTime created_at) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.parent_id = parent_id;
		this.icon = icon;
		this.created_at = created_at;
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
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	

}
