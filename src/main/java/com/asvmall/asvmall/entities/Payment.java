package com.asvmall.asvmall.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    private int order_id;
    private double amount;
    private String status;
    private String payment_mode;

    @CreationTimestamp
    private LocalDateTime created_on;

    public Payment() {}

    // Getters & Setters
    public int getPayment_id() { return payment_id; }
    public void setPayment_id(int payment_id) { this.payment_id = payment_id; }

    public int getOrder_id() { return order_id; }
    public void setOrder_id(int order_id) { this.order_id = order_id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPayment_mode() { return payment_mode; }
    public void setPayment_mode(String payment_mode) { this.payment_mode = payment_mode; }

    public LocalDateTime getCreated_on() { return created_on; }
    public void setCreated_on(LocalDateTime created_on) { this.created_on = created_on; }

	public Payment(int payment_id, int order_id, double amount, String status, String payment_mode,
			LocalDateTime created_on) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.amount = amount;
		this.status = status;
		this.payment_mode = payment_mode;
		this.created_on = created_on;
	}
    
}

