package com.example.demo.Converter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UserOrderDto;
import com.example.demo.models.Product;
import com.example.demo.models.UserOrder;

@Component
public class OrderConverter {
    @Autowired
    UserConverter userConverter;

    public UserOrderDto entityToDto(UserOrder userOrder) {
        if (userOrder == null)
            return null;
        UserOrderDto userOrderDto = new UserOrderDto();

        userOrderDto.setOrderId(userOrder.getOrderId());
        userOrderDto.setAddress(userOrder.getAddress());
        userOrderDto.setAmount(userOrder.getAmount());
        userOrderDto.setCity(userOrder.getCity());
        userOrderDto.setCountry(userOrder.getCountry());
        userOrderDto.setEmail(userOrder.getEmail());
        userOrderDto.setName(userOrder.getName());
        userOrderDto.setPhone(userOrder.getPhone());
        userOrderDto.setShipped(userOrder.isShipped());
        userOrderDto.setShippingCharge(userOrder.getShippingCharge());
        userOrderDto.setState(userOrder.getState());
        userOrderDto.setUserDto(userConverter.entityToDto(userOrder.getUser()));
        userOrderDto.setZip(userOrder.getZip());

        return userOrderDto;
    }

    public List<UserOrderDto> entityToDto(List<UserOrder> userOrders) {
        if (userOrders == null)
            return null;

        return userOrders.stream().map(userOrder -> entityToDto(userOrder)).collect(Collectors.toList());
    }


    public UserOrder dtoToEntity(UserOrderDto userOrderDto) {
        if (userOrderDto == null)
            return null;
        UserOrder userOrder = new UserOrder();

        userOrder.setOrderId(userOrderDto.getOrderId());
        userOrder.setAddress(userOrderDto.getAddress());
        userOrder.setAmount(userOrderDto.getAmount());
        userOrder.setCity(userOrderDto.getCity());
        userOrder.setCountry(userOrderDto.getCountry());
        userOrder.setEmail(userOrderDto.getEmail());
        userOrder.setName(userOrderDto.getName());
        userOrder.setPhone(userOrderDto.getPhone());
        userOrder.setShipped(userOrderDto.isShipped());
        userOrder.setShippingCharge(userOrderDto.getShippingCharge());
        userOrder.setState(userOrderDto.getState());
        userOrder.setUser(userConverter.dtoToEntity(userOrderDto.getUserDto()));
        userOrder.setZip(userOrderDto.getZip());

        return userOrder;
    }

    public List<UserOrder> dtoToEntity(List<UserOrderDto> userOrderDtos) {
        if (userOrderDtos == null)
            return null;

        return userOrderDtos.stream().map(userOrderDto -> dtoToEntity(userOrderDto)).collect(Collectors.toList());
    }
}
