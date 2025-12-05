package com.shiva.Asvmall.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "otp_verification")
public class OtpVerificationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="mobile")
	private String mobile;
	@Column(name="otp_code")
	private String otp_code;
	@Column(name="otp_status")
	private String otp_status;
	@Column(name="created_at")
	private LocalDateTime created_at;
	@Column(name="expires_at")
	private LocalDateTime expires_at;
	public OtpVerificationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpVerificationEntity(Integer id, String mobile, String otp_code, String otp_status,
			LocalDateTime created_at, LocalDateTime expires_at) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.otp_code = otp_code;
		this.otp_status = otp_status;
		this.created_at = created_at;
		this.expires_at = expires_at;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOtp_code() {
		return otp_code;
	}
	public void setOtp_code(String otp_code) {
		this.otp_code = otp_code;
	}
	public String getOtp_status() {
		return otp_status;
	}
	public void setOtp_status(String otp_status) {
		this.otp_status = otp_status;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getExpires_at() {
		return expires_at;
	}
	public void setExpires_at(LocalDateTime expires_at) {
		this.expires_at = expires_at;
	}
	
	
}
