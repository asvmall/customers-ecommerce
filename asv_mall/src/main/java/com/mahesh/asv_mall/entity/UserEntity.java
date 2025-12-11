package com.mahesh.asv_mall.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer user_id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password_hash")
	private String password_hash;
	@Column(name="phone")
	private String phone;
	@Column(name="role")
	private String role;
	@Column(name="created_at")
	private LocalDate created_at;
	@Column(name="updated_at")
	private LocalDate LocalDate;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(Integer user_id, String name, String email, String password_hash, String phone, String role,
			java.time.LocalDate created_at, java.time.LocalDate localDate) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password_hash = password_hash;
		this.phone = phone;
		this.role = role;
		this.created_at = created_at;
		LocalDate = localDate;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword_hash() {
		return password_hash;
	}
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public LocalDate getLocalDate() {
		return LocalDate;
	}
	public void setLocalDate(LocalDate localDate) {
		LocalDate = localDate;
	}

}
