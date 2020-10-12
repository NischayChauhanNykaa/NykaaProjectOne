package com.example.demo.Converter;

import com.example.demo.dto.UserOrderDetailsDto;
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

    public UserOrderDetailsDto entityToDto(UserOrderDetails userOrderDetails) {
        if (userOrderDetails == null)
            return null;

        UserOrderDetailsDto userOrderDetailsDto = new UserOrderDetailsDto();
        userOrderDetailsDto.setDetailId(userOrderDetails.getDetailId());
        userOrderDetailsDto.setName(userOrderDetails.getName());
        userOrderDetailsDto.setPrice(userOrderDetails.getPrice());
        userOrderDetailsDto.setProductDto(productConverter.entityToDto(userOrderDetails.getProduct()));
        userOrderDetailsDto.setUserOrderDto(userOrderConverter.entityToDto(userOrderDetails.getUserOrder()));
        userOrderDetailsDto.setQuantity(userOrderDetails.getQuantity());

        return userOrderDetailsDto;
    }

    public List<UserOrderDetailsDto> entityToDto(List<UserOrderDetails> userOrdersDetails) {
        if (userOrdersDetails == null)
            return null;

        return userOrdersDetails.stream().map(userOrderDetail -> entityToDto(userOrderDetail)).collect(Collectors.toList());
    }


    public UserOrderDetails dtoToEntity(UserOrderDetailsDto userOrderDetailsDto) {
        if (userOrderDetailsDto == null)
            return null;
        UserOrderDetails userOrderDetails = new UserOrderDetails();
        userOrderDetails.setDetailId(userOrderDetailsDto.getDetailId());
        userOrderDetails.setName(userOrderDetailsDto.getName());
        userOrderDetails.setPrice(userOrderDetailsDto.getPrice());
        userOrderDetails.setProduct(productConverter.dtoToEntity(userOrderDetailsDto.getProductDto()));
        userOrderDetails.setUserOrder(userOrderConverter.dtoToEntity(userOrderDetailsDto.getUserOrderDto()));
        userOrderDetails.setQuantity(userOrderDetailsDto.getQuantity());

        return userOrderDetails;
    }

    public List<UserOrderDetails> dtoToEntity(List<UserOrderDetailsDto> userOrderDetailsDtos) {
        if (userOrderDetailsDtos == null)
            return null;

        return userOrderDetailsDtos.stream().map(userOrderDetailsDto -> dtoToEntity(userOrderDetailsDto)).collect(Collectors.toList());
    }

}
