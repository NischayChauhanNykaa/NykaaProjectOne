package com.example.demo.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderDto;
import com.example.demo.models.UserOrder;

@Component
public class OrderConverter {
    @Autowired
    UserConverter userConverter;

    public OrderDto entityToDto(UserOrder userOrder) {
        if (userOrder == null)
            return null;
        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId(userOrder.getOrderId());
        orderDto.setAddress(userOrder.getAddress());
        orderDto.setAmount(userOrder.getAmount());
        orderDto.setCity(userOrder.getCity());
        orderDto.setCountry(userOrder.getCountry());
        orderDto.setEmail(userOrder.getEmail());
        orderDto.setName(userOrder.getName());
        orderDto.setPhone(userOrder.getPhone());
        orderDto.setShipped(userOrder.isShipped());
        orderDto.setShippingCharge(userOrder.getShippingCharge());
        orderDto.setState(userOrder.getState());
        orderDto.setUserDto(userConverter.entityToDto(userOrder.getUser()));
        orderDto.setZip(userOrder.getZip());

        return orderDto;
    }

    public List<OrderDto> entityToDto(List<UserOrder> userOrders) {
        if (userOrders == null)
            return null;

        return userOrders.stream().map(userOrder -> entityToDto(userOrder)).collect(Collectors.toList());
    }


    public UserOrder dtoToEntity(OrderDto orderDto) {
        if (orderDto == null)
            return null;
        UserOrder userOrder = new UserOrder();

        userOrder.setOrderId(orderDto.getOrderId());
        userOrder.setAddress(orderDto.getAddress());
        userOrder.setAmount(orderDto.getAmount());
        userOrder.setCity(orderDto.getCity());
        userOrder.setCountry(orderDto.getCountry());
        userOrder.setEmail(orderDto.getEmail());
        userOrder.setName(orderDto.getName());
        userOrder.setPhone(orderDto.getPhone());
        userOrder.setShipped(orderDto.isShipped());
        userOrder.setShippingCharge(orderDto.getShippingCharge());
        userOrder.setState(orderDto.getState());
        userOrder.setUser(userConverter.dtoToEntity(orderDto.getUserDto()));
        userOrder.setZip(orderDto.getZip());

        return userOrder;
    }

    public List<UserOrder> dtoToEntity(List<OrderDto> orderDtos) {
        if (orderDtos == null)
            return null;

        return orderDtos.stream().map(userOrderDto -> dtoToEntity(userOrderDto)).collect(Collectors.toList());
    }
}
