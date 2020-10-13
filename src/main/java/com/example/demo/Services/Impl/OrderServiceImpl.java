package com.example.demo.Services.Impl;

import com.example.demo.Converter.MyOrdersConverter;
import com.example.demo.Services.Structure.OrderDetailsService;
import com.example.demo.dto.*;
import com.example.demo.models.User;
import com.example.demo.models.UserOrder;
import com.example.demo.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Converter.OrderConverter;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderConverter userOrderConverter;

	@Autowired
	OrderDetailsService orderDetailsService;

	@Autowired
	MyOrdersConverter myOrdersConverter;

	@Autowired
	UserRepository userRepository;
	
	Logger logger = LogManager.getLogger(OrderService.class);


	@Override
	public boolean createOrder(OrderDto orderDto) {
		if(orderDto ==null)
			return false;
			
		try {
			orderRepository.save( userOrderConverter.dtoToEntity(orderDto) );
			return true;
		} catch (Exception e) {
			logger.error("Error while saving "+e.getMessage());
		}
		
		return false;
	}

	@Override
	public ResponseDto fetch(long id) {
		ResponseDto responseDto = new ResponseDto();
		try {
			UserOrder userOrder = orderRepository.findByOrderId(id);
			List<DetailDto> orderDetails = orderDetailsService.getOrderDetails(userOrder);
			if(userOrder == null) {
				responseDto.setHttpStatus(404);
				throw new Exception("Order with the id " + id + " not found");
			}
			responseDto.setData(myOrdersConverter.toDto(userOrder, orderDetails));
			responseDto.setSuccess(true);
			responseDto.setHttpStatus(200);
			responseDto.setMessage("Order details found");
			logger.info("Order " + id + " details found");
		} catch (Exception e) {
			logger.error("Error while fetching order details : " + e.getMessage());
			responseDto.setSuccess(false);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}


	@Override
	public ResponseDto getByUser(User userEmail) {
		ResponseDto responseDto = new ResponseDto();
		try {
			User user = userRepository.findByEmailAndDeleted(userEmail.getEmail(), false);
			if(user == null) {
				responseDto.setHttpStatus(404);
				throw new Exception("User with email " + userEmail.getEmail() + " not found");
			}
			List<UserOrder> userOrders = orderRepository.findByUser(user);
			if(userOrders.isEmpty()) {
				responseDto.setHttpStatus(404);
				throw new Exception("Orders not found for the user " + userEmail.getEmail());
			}
			MyOrdersDto myOrdersDto = new MyOrdersDto();
			List<DetailedOrderDto> orders = new ArrayList<>();
			userOrders.forEach(order -> {
				List<DetailDto> orderDetails = orderDetailsService.getOrderDetails(order);
				orders.add(myOrdersConverter.toDto(order, orderDetails));
			});
			myOrdersDto.setUserId(user.getUserId());
			myOrdersDto.setUserOrders(orders);
			responseDto.setData(myOrdersDto);
			responseDto.setSuccess(true);
			responseDto.setHttpStatus(200);
			responseDto.setMessage("Orders of user found");
			logger.info("Orders for user {} found", user.getEmail());
		} catch (Exception e) {
			logger.error(e.getMessage());
			responseDto.setSuccess(false);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}

}
