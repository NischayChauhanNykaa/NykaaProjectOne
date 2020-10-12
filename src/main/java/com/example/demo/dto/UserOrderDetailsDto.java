package com.example.demo.dto;

public class UserOrderDetailsDto {

    private long detailId;
    private UserOrderDto userOrderDto;

    private ProductDto productDto;

    private String name;
    private double price;
    private int quantity;

    public UserOrderDetailsDto(){}

    public UserOrderDetailsDto(long detailId, UserOrderDto userOrderDto, ProductDto productDto, String name, double price, int quantity) {
        this.detailId = detailId;
        this.userOrderDto = userOrderDto;
        this.productDto = productDto;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    public UserOrderDto getUserOrderDto() {
        return userOrderDto;
    }

    public void setUserOrderDto(UserOrderDto userOrderDto) {
        this.userOrderDto = userOrderDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
