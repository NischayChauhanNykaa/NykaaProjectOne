package com.example.demo.models;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;

	@Column(length = 50,nullable = false)
	private String name;

	@Column(updatable = false)
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;
	
	private boolean deleted = false;
	
	public ProductCategory() {}
	

	public ProductCategory(String name) {
		super();
		this.name = name;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	


	public long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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
	
}