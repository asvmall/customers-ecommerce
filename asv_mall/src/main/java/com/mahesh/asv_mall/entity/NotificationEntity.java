package com.mahesh.asv_mall.entity;

import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="notification")
public class NotificationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="notification_id")
	private Integer notification_id;
	
	@Column(name="title")
	private String title;
	@Column(name="message")
	private String message;
	@Column(name="is_read")
	private String is_read;
	@Column(name="created_at")
	private LocalDate created_at;
	@Column(name="image")
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public NotificationEntity(String image) {
		super();
		this.image = image;
	}
	@OneToOne
	@JoinColumn(name="user_id")
	UserEntity userEntity;
	public NotificationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotificationEntity(Integer notification_id, String title, String message, String is_read,
			LocalDate created_at, UserEntity userEntity) {
		super();
		this.notification_id = notification_id;
		this.title = title;
		this.message = message;
		this.is_read = is_read;
		this.created_at = created_at;
		this.userEntity = userEntity;
	}
	public Integer getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(Integer notification_id) {
		this.notification_id = notification_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIs_read() {
		return is_read;
	}
	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}