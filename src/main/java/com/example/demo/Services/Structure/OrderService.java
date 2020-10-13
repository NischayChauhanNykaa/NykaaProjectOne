package com.example.demo.Services.Structure;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.MyOrdersDto;
import com.example.demo.models.User;

import java.util.List;

public interface OrderService {

	
	boolean createOrder(OrderDto orderDto);
	
	ResponseDto fetch(long id);

	ResponseDto getByUser(User user);
}
