package com.example.demo.dto;

public class ProductCategoryDto {
	
	private long categoryId;
	
	private String categoryName;

	public ProductCategoryDto() {
	}
	
	public ProductCategoryDto(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}