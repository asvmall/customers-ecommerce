package com.asvmall.asvmall.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "banners")
public class Banners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int banner_id;

    private String title;
    private String image_url;
    private String record_status;

    public Banners() {}

    // Getters & Setters
    public int getBanner_id() { return banner_id; }
    public void setBanner_id(int banner_id) { this.banner_id = banner_id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImage_url() { return image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }

    public String getRecord_status() { return record_status; }
    public void setRecord_status(String record_status) { this.record_status = record_status; }

	public Banners(int banner_id, String title, String image_url, String record_status) {
		super();
		this.banner_id = banner_id;
		this.title = title;
		this.image_url = image_url;
		this.record_status = record_status;
	}
    
}

