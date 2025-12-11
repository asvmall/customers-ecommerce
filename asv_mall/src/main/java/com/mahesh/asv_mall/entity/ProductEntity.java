package com.mahesh.asv_mall.entity;




	import java.math.BigDecimal;
	import java.sql.Timestamp;

	import jakarta.persistence.*;

	@Entity
	@Table(name = "products")
	public class ProductEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "product_id")
	    private Integer productId;

	    @Column(name = "seller_id")
	    private Integer sellerId;

	    @Column(name = "category_id")
	    private Integer categoryId;

	    @Column(name = "name", length = 150)
	    private String name;

	    @Column(name = "description", columnDefinition = "TEXT")
	    private String description;

	    @Column(name = "price", precision = 10, scale = 2)
	    private BigDecimal price;

	    @Column(name = "discount", precision = 5, scale = 2)
	    private BigDecimal discount;

	    @Column(name = "stock")
	    private Integer stock;

	    @Column(name = "sku", length = 100)
	    private String sku;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "status")
	    private Status status;

	    @Column(name = "created_at")
	    private Timestamp createdAt;

	    @Column(name = "updated_at")
	    private Timestamp updatedAt;

	    @Column(name = "image", length = 200)
	    private String image;

	    public enum Status {
	        active,
	        inactive
	    }

	    public ProductEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		public ProductEntity(Integer productId, Integer sellerId, Integer categoryId, String name, String description,
				BigDecimal price, BigDecimal discount, Integer stock, String sku, Status status, Timestamp createdAt,
				Timestamp updatedAt, String image) {
			super();
			this.productId = productId;
			this.sellerId = sellerId;
			this.categoryId = categoryId;
			this.name = name;
			this.description = description;
			this.price = price;
			this.discount = discount;
			this.stock = stock;
			this.sku = sku;
			this.status = status;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.image = image;
		}

		// Getters & Setters
	    public Integer getProductId() {
	        return productId;
	    }
	    public void setProductId(Integer productId) {
	        this.productId = productId;
	    }

	    public Integer getSellerId() {
	        return sellerId;
	    }
	    public void setSellerId(Integer sellerId) {
	        this.sellerId = sellerId;
	    }

	    public Integer getCategoryId() {
	        return categoryId;
	    }
	    public void setCategoryId(Integer categoryId) {
	        this.categoryId = categoryId;
	    }

	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }
	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }

	    public BigDecimal getDiscount() {
	        return discount;
	    }
	    public void setDiscount(BigDecimal discount) {
	        this.discount = discount;
	    }

	    public Integer getStock() {
	        return stock;
	    }
	    public void setStock(Integer stock) {
	        this.stock = stock;
	    }

	    public String getSku() {
	        return sku;
	    }
	    public void setSku(String sku) {
	        this.sku = sku;
	    }

	    public Status getStatus() {
	        return status;
	    }
	    public void setStatus(Status status) {
	        this.status = status;
	    }

	    public Timestamp getCreatedAt() {
	        return createdAt;
	    }
	    public void setCreatedAt(Timestamp createdAt) {
	        this.createdAt = createdAt;
	    }

	    public Timestamp getUpdatedAt() {
	        return updatedAt;
	    }
	    public void setUpdatedAt(Timestamp updatedAt) {
	        this.updatedAt = updatedAt;
	    }

	    public String getImage() {
	        return image;
	    }
	    public void setImage(String image) {
	        this.image = image;
	    }
	}


