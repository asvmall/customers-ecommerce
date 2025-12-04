package com.asvmall.asvmall.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;

    private int user_id;
    private int products_id;
    private int quantity;

    @CreationTimestamp
    private LocalDateTime added_on;

    public Cart() {}

    // Getters & Setters
    public int getCart_id() { return cart_id; }
    public void setCart_id(int cart_id) { this.cart_id = cart_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getProducts_id() { return products_id; }
    public void setProducts_id(int products_id) { this.products_id = products_id; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDateTime getAdded_on() { return added_on; }
    public void setAdded_on(LocalDateTime added_on) { this.added_on = added_on; }

	public Cart(int cart_id, int user_id, int products_id, int quantity, LocalDateTime added_on) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.products_id = products_id;
		this.quantity = quantity;
		this.added_on = added_on;
	}
    
}

