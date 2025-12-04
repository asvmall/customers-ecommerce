package com.asvmall.asvmall.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    private String category_name;
    private String record_status;

    public Categories() {}

    // Getters & Setters
    public int getCategory_id() { return category_id; }
    public void setCategory_id(int category_id) { this.category_id = category_id; }

    public String getCategory_name() { return category_name; }
    public void setCategory_name(String category_name) { this.category_name = category_name; }

    public String getRecord_status() { return record_status; }
    public void setRecord_status(String record_status) { this.record_status = record_status; }

	public Categories(int category_id, String category_name, String record_status) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.record_status = record_status;
	}
    
}

