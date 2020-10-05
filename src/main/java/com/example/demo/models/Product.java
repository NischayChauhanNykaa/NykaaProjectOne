package com.example.demo.models;

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


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@ManyToOne(fetch = FetchType.EAGER)
	private ProductCategory productCategory;
	
	@Column(length = 50,nullable = false)
	private String productName;

	@Column(length = 20,nullable = false)
	private String productPrice;

	@Column(length = 255,nullable = false)
	private String productImage;

	@Column(length = 50,nullable = false)
	private String productThumbnail;

	@Column(length = 250,nullable = false)
	private String productLocation;

	@Column(length = 1000,nullable = false)
	private String prodcutInfo;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated = new Date();

	
	private boolean deleted;
	
	
	public Product() {}
	
	public Product(long productId, ProductCategory productCategory, String productName, String productPrice,
			String productImage, String productThumbnail, String productLocation, String prodcutInfo) {
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productThumbnail = productThumbnail;
		this.productLocation = productLocation;
		this.prodcutInfo = prodcutInfo;
	}
	public Product(String productName, String productPrice,
			String productImage, String productThumbnail, String productLocation, String prodcutInfo) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productThumbnail = productThumbnail;
		this.productLocation = productLocation;
		this.prodcutInfo = prodcutInfo;
	}
	
	public Date getCreated() {
		return created;
	}
	

	
	

	public void setProductId(long productId) {
		this.productId = productId;
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
	
	public long getProductId() {
		return productId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductThumbnail() {
		return productThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getProdcutInfo() {
		return prodcutInfo;
	}

	public void setProdcutInfo(String prodcutInfo) {
		this.prodcutInfo = prodcutInfo;
	}
	
	
	
}