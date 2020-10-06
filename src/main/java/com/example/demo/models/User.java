package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String firstName;
	private String lastName;
	
	private String email;
	private String phone;
	private String password;
	
	private boolean emailVerified;

	private String address;
	private String city;
	private String state;
	private String zip;

	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp created;
	@UpdateTimestamp
	private Timestamp updated;
	
	private boolean deleted = false;
	
	public User() {
	}

	public User(String firstName, String lastName, String email, String phone,
			String password, boolean emailVerified, String address,
			String city, String state, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.emailVerified = emailVerified;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Timestamp getCreated() {
		return created;
	}
	

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEmailVerified() {
		return emailVerified;
	}


	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
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
	
	
	
}
