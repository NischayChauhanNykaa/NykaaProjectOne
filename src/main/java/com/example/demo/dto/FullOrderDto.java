package com.example.demo.dto;

import java.util.List;

public class FullOrderDto {
    private OrderDto orderDto;
    private List<OrderDetailsDto> orderDetailsDtos;

    public FullOrderDto() {
    }

    public FullOrderDto(OrderDto orderDto, List<OrderDetailsDto> orderDetailsDtos) {
        this.orderDto = orderDto;
        this.orderDetailsDtos = orderDetailsDtos;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public List<OrderDetailsDto> getOrderDetailsDtos() {
        return orderDetailsDtos;
    }

    public void setOrderDetailsDtos(List<OrderDetailsDto> orderDetailsDtos) {
        this.orderDetailsDtos = orderDetailsDtos;
    }
}
