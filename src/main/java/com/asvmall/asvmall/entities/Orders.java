package com.asvmall.asvmall.entities;



import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    private int user_id;
    private double total_amount;
    private String status;

    @CreationTimestamp
    private LocalDateTime created_on;

    public Orders() {}

    // Getters & Setters
    public int getOrder_id() { return order_id; }
    public void setOrder_id(int order_id) { this.order_id = order_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public double getTotal_amount() { return total_amount; }
    public void setTotal_amount(double total_amount) { this.total_amount = total_amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreated_on() { return created_on; }
    public void setCreated_on(LocalDateTime created_on) { this.created_on = created_on; }

	public Orders(int order_id, int user_id, double total_amount, String status, LocalDateTime created_on) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.status = status;
		this.created_on = created_on;
	}
    
}

