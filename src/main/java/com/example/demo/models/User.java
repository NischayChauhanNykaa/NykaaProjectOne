package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
	
	private Date created;
	private Date updated;
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
	

	public void setCreated(Date created) {
		this.created = created;
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
	
	public long getUserID() {
		return userId;
	}


	public String getUserFirstName() {
		return firstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.firstName = userFirstName;
	}


	public String getUserLastName() {
		return lastName;
	}


	public void setUserLastName(String userLastName) {
		this.lastName = userLastName;
	}


	public String getUserEmail() {
		return email;
	}


	public void setUserEmail(String userEmail) {
		this.email = userEmail;
	}


	public String getUserPhone() {
		return phone;
	}


	public void setUserPhone(String userPhone) {
		this.phone = userPhone;
	}


	public String getUserPassword() {
		return password;
	}


	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}


	public boolean isUserEmailVerified() {
		return emailVerified;
	}


	public void setUserEmailVerified(boolean userEmailVerified) {
		this.emailVerified = userEmailVerified;
	}


	public Date getUserRegistrationDate() {
		return registrationDate;
	}


	public void setUserRegistrationDate(Date userRegistrationDate) {
		this.registrationDate = userRegistrationDate;
	}


	public String getUserAddress() {
		return address;
	}


	public void setUserAddress(String userAddress) {
		this.address = userAddress;
	}


	public String getUserCity() {
		return city;
	}


	public void setUserCity(String userCity) {
		this.city = userCity;
	}


	public String getUserState() {
		return state;
	}


	public void setUserState(String userState) {
		this.state = userState;
	}


	public String getUserZip() {
		return zip;
	}


	public void setUserZip(String userZip) {
		this.zip = userZip;
	}
	
	
	
}
