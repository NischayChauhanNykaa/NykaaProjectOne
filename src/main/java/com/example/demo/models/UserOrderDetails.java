package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	
	
	
}
