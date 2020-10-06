package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class UserOrderDetails {
	
	@Id
	@GeneratedValue
	private long detailsId;
	
	
	@ManyToOne
	private UserOrder orderId;
	
	@ManyToOne
	private Product productId;
	
	private String detailsName;
	private String detailsPrice;
	private int detailsQuantity;

	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp created;
	@UpdateTimestamp
	private Timestamp updated;
	private boolean deleted;
	
	public UserOrderDetails() {}
		
	public UserOrderDetails(String detailsName, String detailsPrice, int detailsQuantity) {
		this.detailsName = detailsName;
		this.detailsPrice = detailsPrice;
		this.detailsQuantity = detailsQuantity;
	}

	public long getDetailsId() {
		return detailsId;
	}

	

	public UserOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(UserOrder orderId) {
		this.orderId = orderId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getDetailsName() {
		return detailsName;
	}

	public void setDetailsName(String detailsName) {
		this.detailsName = detailsName;
	}

	public String getDetailsPrice() {
		return detailsPrice;
	}

	public void setDetailsPrice(String detailsPrice) {
		this.detailsPrice = detailsPrice;
	}

	public int getDetailsQuantity() {
		return detailsQuantity;
	}

	public void setDetailsQuantity(int detailsQuantity) {
		this.detailsQuantity = detailsQuantity;
	}


	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
