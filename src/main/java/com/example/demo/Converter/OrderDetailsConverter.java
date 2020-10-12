package com.example.demo.Converter;

import com.example.demo.dto.OrderDetailsDto;
import com.example.demo.models.UserOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDetailsConverter {

    @Autowired
    ProductConverter productConverter;

    @Autowired
    OrderConverter userOrderConverter;

    public OrderDetailsDto entityToDto(UserOrderDetails userOrderDetails) {
        if (userOrderDetails == null)
            return null;

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        orderDetailsDto.setDetailId(userOrderDetails.getDetailId());
        orderDetailsDto.setName(userOrderDetails.getName());
        orderDetailsDto.setPrice(userOrderDetails.getPrice());
        orderDetailsDto.setProductDto(productConverter.entityToDto(userOrderDetails.getProduct()));
        orderDetailsDto.setUserOrderDto(userOrderConverter.entityToDto(userOrderDetails.getUserOrder()));
        orderDetailsDto.setQuantity(userOrderDetails.getQuantity());

        return orderDetailsDto;
    }

    public List<OrderDetailsDto> entityToDto(List<UserOrderDetails> userOrdersDetails) {
        if (userOrdersDetails == null)
            return null;

        return userOrdersDetails.stream().map(userOrderDetail -> entityToDto(userOrderDetail)).collect(Collectors.toList());
    }


    public UserOrderDetails dtoToEntity(OrderDetailsDto orderDetailsDto) {
        if (orderDetailsDto == null)
            return null;
        UserOrderDetails userOrderDetails = new UserOrderDetails();
        userOrderDetails.setDetailId(orderDetailsDto.getDetailId());
        userOrderDetails.setName(orderDetailsDto.getName());
        userOrderDetails.setPrice(orderDetailsDto.getPrice());
        userOrderDetails.setProduct(productConverter.dtoToEntity(orderDetailsDto.getProductDto()));
        userOrderDetails.setUserOrder(userOrderConverter.dtoToEntity(orderDetailsDto.getUserOrderDto()));
        userOrderDetails.setQuantity(orderDetailsDto.getQuantity());

        return userOrderDetails;
    }

    public List<UserOrderDetails> dtoToEntity(List<OrderDetailsDto> orderDetailsDtos) {
        if (orderDetailsDtos == null)
            return null;

        return orderDetailsDtos.stream().map(orderDetailsDto -> dtoToEntity(orderDetailsDto)).collect(Collectors.toList());
    }

}
