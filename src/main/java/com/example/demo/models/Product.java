package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@ManyToOne(fetch = FetchType.EAGER)
	private ProductCategory productCategory;
	
	private String productName;
	private String productPrice;
	private String productImage;
	private String productThumbnail;
	private String productLocation;
	private String prodcutInfo;
	
	private Date created;
	private Date updated;
	private boolean deleted;
	
	
	public Product() {}
	
	public Product(String productName, String productPrice, String productImage, String productThumbnail,
			String productLocation, String prodcutInfo1, String prodcutInfo2, String prodcutInfo3, String prodcutInfo4,
			String prodcutInfo5) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productThumbnail = productThumbnail;
		this.productLocation = productLocation;
		this.setProdcutInfo1(prodcutInfo1);
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

	public String getProdcutInfo1() {
		return prodcutInfo;
	}

	public void setProdcutInfo1(String prodcutInfo1) {
		this.prodcutInfo = prodcutInfo1;
	}
	
	
	
}
