package com.example.demo.Services.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Converter.OrderConverter;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.UserOrderDto;
import com.example.demo.repositories.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired
	private OrderConverter userOrderConverter;

	
	Logger logger = LogManager.getLogger(OrderService.class);

	
	@Override
	public boolean createOrder(UserOrderDto userOrderDto) {
		if(userOrderDto==null)
			return false;
			
		try {
			orderRepository.save( userOrderConverter.dtoToEntity(userOrderDto) );
			return true;
		} catch (Exception e) {
			logger.error("Error while saving "+e.getMessage());
		}
		
		return false;
	}

}
