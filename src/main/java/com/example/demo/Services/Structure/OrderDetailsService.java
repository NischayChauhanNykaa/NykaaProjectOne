package com.example.demo.Services.Structure;

import com.example.demo.dto.DetailDto;
import com.example.demo.dto.OrderDetailsDto;
import com.example.demo.models.UserOrder;
import com.example.demo.models.UserOrderDetails;

import java.util.List;

public interface OrderDetailsService {
    boolean createOrderDetails(OrderDetailsDto orderDetailsDto);

    List<DetailDto> getOrderDetails(UserOrder userOrder);
}
