package com.example.demo.Controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.RouteMap;
import com.example.demo.Converter.UserOrderConverter;
import com.example.demo.Services.Structure.UserOrderService;
import com.example.demo.dto.UserOrderDto;
import com.example.demo.repositories.OrdersRepository;

@RestController
@RequestMapping(value = RouteMap.ORDER_CONTROLLER)
public class OrderController {
	
	Logger logger = LogManager.getLogger(OrderController.class);

	@Autowired
	UserOrderService userOrderService;
	
	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	UserOrderConverter conv;
	
	/* Create Order Input --> userOrder */
	@RequestMapping(value = RouteMap.ORDER_CONTROLLER_SET_ORDER)
	public ResponseEntity<Object> createOrder(@RequestBody UserOrderDto userOrderDto) {
		if(userOrderService.createOrder(userOrderDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@RequestMapping(value = "/get")
	public UserOrderDto reateOrder() {
		return conv.entityToDto(orderRepo.findAll().get(0));
	}
	
	
}
