package com.example.demo.Services.Structure;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.ResponseDto;

public interface OrderService {

	
	boolean createOrder(OrderDto orderDto);
	
	ResponseDto fetch(long id);
}
