package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	
	private String categoryName;

	private Date created;
	private Date updated;
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
