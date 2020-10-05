package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;
import  java.sql.Timestamp;

@Entity
public class UserOrder {
	
	@Id
	@GeneratedValue
	private long orderId;
	
	@ManyToOne
	private User orderUserId;
		
	private float orderAmount;
	private float orderShipmentCharge;
	
	private String orderShipmentName;
	private String orderShipmentAddress;
	private String orderCity;
	private String orderState;
	private String orderZip;
	private String orderCountry;
	private String orderPhone;
	private String orderEmail;
	private boolean orderShipped;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated = new Date();

	
	private boolean deleted;
	

	public UserOrder() {
	}



	public UserOrder(float orderAmount, float orderShipmentCharge, String orderShipmentName,
			String orderShipmentAddress, String orderCity, String orderState, String orderZip, String orderCountry,
			String orderPhone, String orderEmail, boolean orderShipped) {
		this.orderAmount = orderAmount;
		this.orderShipmentCharge = orderShipmentCharge;
		this.orderShipmentName = orderShipmentName;
		this.orderShipmentAddress = orderShipmentAddress;
		this.orderCity = orderCity;
		this.orderState = orderState;
		this.orderZip = orderZip;
		this.orderCountry = orderCountry;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.orderShipped = orderShipped;
	}



	public long getOrderId() {
		return orderId;
	}



	public User getOrderUserId() {
		return orderUserId;
	}



	public void setOrderUserId(User orderUserId) {
		this.orderUserId = orderUserId;
	}



	public float getOrderAmount() {
		return orderAmount;
	}



	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}



	public float getOrderShipmentCharge() {
		return orderShipmentCharge;
	}



	public void setOrderShipmentCharge(float orderShipmentCharge) {
		this.orderShipmentCharge = orderShipmentCharge;
	}



	public String getOrderShipmentName() {
		return orderShipmentName;
	}



	public void setOrderShipmentName(String orderShipmentName) {
		this.orderShipmentName = orderShipmentName;
	}



	public String getOrderShipmentAddress() {
		return orderShipmentAddress;
	}



	public void setOrderShipmentAddress(String orderShipmentAddress) {
		this.orderShipmentAddress = orderShipmentAddress;
	}



	public String getOrderCity() {
		return orderCity;
	}



	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}



	public String getOrderState() {
		return orderState;
	}



	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}



	public String getOrderZip() {
		return orderZip;
	}



	public void setOrderZip(String orderZip) {
		this.orderZip = orderZip;
	}



	public String getOrderCountry() {
		return orderCountry;
	}



	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}



	public String getOrderPhone() {
		return orderPhone;
	}



	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}



	public String getOrderEmail() {
		return orderEmail;
	}



	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}



	public boolean isOrderShipped() {
		return orderShipped;
	}



	public void setOrderShipped(boolean orderShipped) {
		this.orderShipped = orderShipped;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Date getUpdated() {
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
