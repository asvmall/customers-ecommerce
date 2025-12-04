package com.asvmall.asvmall.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "sellers")
public class Sellers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seller_id;

    private int user_id;
    private String shop_name;
    private String gst_number;
    private String status;

    @CreationTimestamp
    private LocalDateTime created_on;

    public Sellers() {}

    // Getters & Setters
    public int getSeller_id() { return seller_id; }
    public void setSeller_id(int seller_id) { this.seller_id = seller_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public String getShop_name() { return shop_name; }
    public void setShop_name(String shop_name) { this.shop_name = shop_name; }

    public String getGst_number() { return gst_number; }
    public void setGst_number(String gst_number) { this.gst_number = gst_number; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreated_on() { return created_on; }
    public void setCreated_on(LocalDateTime created_on) { this.created_on = created_on; }

	public Sellers(int seller_id, int user_id, String shop_name, String gst_number, String status,
			LocalDateTime created_on) {
		super();
		this.seller_id = seller_id;
		this.user_id = user_id;
		this.shop_name = shop_name;
		this.gst_number = gst_number;
		this.status = status;
		this.created_on = created_on;
	}
    
}
