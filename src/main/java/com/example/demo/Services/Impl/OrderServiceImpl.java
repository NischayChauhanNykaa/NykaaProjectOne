package com.example.demo.Services.Impl;

import com.example.demo.dto.ResponseDto;
import com.example.demo.models.UserOrder;
import com.example.demo.models.UserOrderDetails;
import com.example.demo.repositories.OrderDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Converter.OrderConverter;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.OrderDto;
import com.example.demo.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter userOrderConverter;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	
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
			List<UserOrderDetails> orderDetails = orderDetailsRepository.findByUserOrder(userOrder);
			if(userOrder == null) {
				responseDto.setHttpStatus(404);
				throw new Exception("Order with the id:" + id + " not found");
			}
			responseDto.setData(userOrderConverter.entityToDto(userOrder));
			responseDto.setSuccess(true);
			responseDto.setHttpStatus(200);
			responseDto.setMessage("Order details found");
			List<String> details = new ArrayList<>();
			orderDetails.stream().forEach(d -> {
				details.add(d.toString());
			});
			responseDto.setDetails(details);
			logger.info("Order details found");
		} catch (Exception e) {
			logger.error("Error while fetching order details : " + e.getMessage());
			responseDto.setSuccess(false);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}


}
