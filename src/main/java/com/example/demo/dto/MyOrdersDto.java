package com.example.demo.dto;

import java.util.List;

public class MyOrdersDto {
    private long userId;
    private List<DetailedOrderDto> userOrders;

    public MyOrdersDto() {
    }

    public MyOrdersDto(long userId, List<DetailedOrderDto> userOrders) {
        this.userId = userId;
        this.userOrders = userOrders;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<DetailedOrderDto> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<DetailedOrderDto> userOrders) {
        this.userOrders = userOrders;
    }
}
