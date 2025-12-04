package com.asvmall.asvmall.entities;




import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int products_id;

    private int category_id;
    private int seller_id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double price;
    private String record_status;

    public Products() {}

    // Getters & Setters
    public int getProducts_id() { return products_id; }
    public void setProducts_id(int products_id) { this.products_id = products_id; }

    public int getCategory_id() { return category_id; }
    public void setCategory_id(int category_id) { this.category_id = category_id; }

    public int getSeller_id() { return seller_id; }
    public void setSeller_id(int seller_id) { this.seller_id = seller_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getRecord_status() { return record_status; }
    public void setRecord_status(String record_status) { this.record_status = record_status; }

	public Products(int products_id, int category_id, int seller_id, String name, String description, double price,
			String record_status) {
		super();
		this.products_id = products_id;
		this.category_id = category_id;
		this.seller_id = seller_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.record_status = record_status;
	}
    
}

