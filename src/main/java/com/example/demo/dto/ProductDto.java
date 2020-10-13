package com.example.demo.dto;


public class ProductDto {
	
	private long productId;
	
	private ProductCategoryDto productCategoryDto;
	
	private String productName;
	private String productPrice;
	private String productImage;
	private String productThumbnail;
	private String productLocation;
	private String prodcutInfo;
	private long quantity;
	
	public ProductDto() {
	}
	
	public ProductDto(long productId, ProductCategoryDto productCategoryDto, String productName, String productPrice,
			String productImage, String productThumbnail, String productLocation, String prodcutInfo,long quantity) {
		super();
		this.productId = productId;
		this.productCategoryDto = productCategoryDto;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productThumbnail = productThumbnail;
		this.productLocation = productLocation;
		this.prodcutInfo = prodcutInfo;
		this.quantity = quantity;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public ProductCategoryDto getProductCategoryDto() {
		return productCategoryDto;
	}

	public void setProductCategoryDto(ProductCategoryDto productCategoryDto) {
		this.productCategoryDto = productCategoryDto;
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

	public String getProdcutInfo() {
		return prodcutInfo;
	}

	public void setProdcutInfo(String prodcutInfo) {
		this.prodcutInfo = prodcutInfo;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice + ", productImage=" + productImage
				+ ", productThumbnail=" + productThumbnail + ", productLocation=" + productLocation + ", prodcutInfo="
				+ prodcutInfo + "]";
	}
	
	
	
}