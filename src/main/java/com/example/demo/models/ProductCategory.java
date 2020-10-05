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
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;

	@Column(length = 50,nullable = false)
	private String categoryName;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated = new Date();
	
	private boolean deleted;
	
	public ProductCategory() {}
	
	public ProductCategory(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	public Date getCreated() {
		return created;
	}
	

	

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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