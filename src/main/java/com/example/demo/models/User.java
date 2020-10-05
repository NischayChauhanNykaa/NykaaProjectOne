package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	private Date registrationDate;
	
	private String address;
	private String city;
	private String state;
	private String zip;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated = new Date();
	
	private boolean deleted;
	
	public User() {
	}

	public User(String userFirstName, String userLastName, String userEmail, String userPhone,
			String userPassword, boolean userEmailVerified, Date userRegistrationDate, String userAddress,
			String userCity, String userState, String userZip) {
		this.firstName = userFirstName;
		this.lastName = userLastName;
		this.email = userEmail;
		this.phone = userPhone;
		this.password = userPassword;
		this.emailVerified = userEmailVerified;
		this.registrationDate = userRegistrationDate;
		this.address = userAddress;
		this.city = userCity;
		this.state = userState;
		this.zip = userZip;
	}

	public Date getCreated() {
		return created;
	}
	

	public Date getUpdated() {
		return updated;
	}
	

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	

	public boolean isDeleted() {
		return deleted;
	}
	

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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

	public void setCreated(Date created) {
		this.created = created;
	}	
	
	
		
	
	
}