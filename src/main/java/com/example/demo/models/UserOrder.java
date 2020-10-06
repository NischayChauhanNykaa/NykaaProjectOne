package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import  java.sql.Timestamp;
import java.text.DecimalFormat;

@Entity
public class UserOrder {
	
	@Id
	@GeneratedValue
	private long orderId;
	
	@ManyToOne
	private User user;

	@Column(columnDefinition="Decimal(10,2)")
	private double amount;

	@Column(columnDefinition="Decimal(10,2)")
	private double shippingCharge;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false, length = 30)
	private String city;
	@Column(nullable = false, length = 30)
	private String state;
	@Column(nullable = false, length = 10)
	private String zip;
	@Column(nullable = false, length = 30)
	private String country;
	@Column(nullable = false, length = 20)
	private String phone;

	@Column(length = 50)
	private String email;

	private boolean shipped;

	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp created;
	@UpdateTimestamp
	private Timestamp updated;
	private boolean deleted;
	

	public UserOrder() {
	}



	public UserOrder(float amount, float shippingCharge, User user, String name,
			String address, String city, String state, String zip, String country,
			String phone, String email, boolean shipped) {
		this.amount = amount;
		this.shippingCharge = shippingCharge;
		this.user = user;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.shipped = shipped;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public double getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(float shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
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
