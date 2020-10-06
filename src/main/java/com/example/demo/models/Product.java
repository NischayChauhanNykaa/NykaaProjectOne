package com.example.demo.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@ManyToOne(fetch = FetchType.EAGER)
	private ProductCategory productCategory;
	
	@Column(length = 50,nullable = false)
	private String name;

	// productPrice -> price
	@Column(length = 20,nullable = false)
	private String price;

	@Column(length = 255,nullable = false)
	private String image;

	@Column(length = 50,nullable = false)
	private String thumbnail;

	@Column(length = 250,nullable = false)
	private String location;

	@Column(length = 1000,nullable = false)
	private String information;

	@Column(updatable = false)
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;

	
	private boolean deleted = false;
	
	
	public Product() {}


	public Product(String name, String price, String image, String thumbnail, String location, String information) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.thumbnail = thumbnail;
		this.location = location;
		this.information = information;
	}


	public Product(long productId, ProductCategory productCategory, String name, String price, String image,
			String thumbnail, String location, String information, Date created, Date updated, boolean deleted) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.name = name;
		this.price = price;
		this.image = image;
		this.thumbnail = thumbnail;
		this.location = location;
		this.information = information;
		this.created = created;
		this.updated = updated;
		this.deleted = deleted;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public ProductCategory getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getInformation() {
		return information;
	}


	public void setInformation(String information) {
		this.information = information;
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
	

	
	
}