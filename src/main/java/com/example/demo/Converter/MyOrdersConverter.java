package com.example.demo.Converter;

import com.example.demo.dto.DetailDto;
import com.example.demo.dto.OrderDetailsDto;
import com.example.demo.dto.DetailedOrderDto;
import com.example.demo.models.UserOrder;
import com.example.demo.models.UserOrderDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyOrdersConverter {

    public DetailedOrderDto toDto(UserOrder order, List<DetailDto> orderDetailsDtos){
        if(order == null || orderDetailsDtos == null){
            return null;
        }
        DetailedOrderDto detailedOrderDto = new DetailedOrderDto();
        detailedOrderDto.setOrderId(order.getOrderId());
        detailedOrderDto.setOrderDetails(orderDetailsDtos);
        detailedOrderDto.setAmount(order.getAmount());
        detailedOrderDto.setShippingCharge(order.getShippingCharge());
        detailedOrderDto.setName(order.getName());
        detailedOrderDto.setAddress(order.getAddress());
        detailedOrderDto.setCity(order.getCity());
        detailedOrderDto.setState(order.getState());
        detailedOrderDto.setZip(order.getZip());
        detailedOrderDto.setCountry(order.getCountry());
        detailedOrderDto.setPhone(order.getPhone());
        detailedOrderDto.setEmail(order.getEmail());
        detailedOrderDto.setShipped(order.isShipped());
        return detailedOrderDto;
    }

    public DetailDto toDetailDto(UserOrderDetails userOrderDetails) {
        if(userOrderDetails == null) return null;
        DetailDto detailDto = new DetailDto();
        detailDto.setDetailId(userOrderDetails.getDetailId());
        detailDto.setName(userOrderDetails.getName());
        detailDto.setPrice(userOrderDetails.getPrice());
        detailDto.setQuantity(userOrderDetails.getQuantity());
        detailDto.setProductId(userOrderDetails.getProduct().getProductId());
        return detailDto;
    }

    public List<DetailDto> toDetailDto(List<UserOrderDetails> userOrdersDetails) {
        if (userOrdersDetails == null) return null;
        return userOrdersDetails.stream().map(this::toDetailDto).collect(Collectors.toList());
    }
}
