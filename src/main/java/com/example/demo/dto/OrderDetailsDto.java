package com.example.demo.dto;

public class OrderDetailsDto {

    private long detailId;
    private OrderDto orderDto;

    private ProductDto productDto;

    private String name;
    private double price;
    private int quantity;

    public OrderDetailsDto(){}

    public OrderDetailsDto(long detailId, OrderDto orderDto, ProductDto productDto, String name, double price, int quantity) {
        this.detailId = detailId;
        this.orderDto = orderDto;
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

    public OrderDto getUserOrderDto() {
        return orderDto;
    }

    public void setUserOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
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
