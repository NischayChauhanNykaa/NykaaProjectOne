package com.example.demo.Controllers;


import com.example.demo.Converter.OrderDetailsConverter;
import com.example.demo.Services.Structure.OrderDetailsService;
import com.example.demo.dto.OrderDetailsDto;
import com.example.demo.repositories.OrderDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.RouteMap;
import com.example.demo.Converter.OrderConverter;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.OrderDto;
import com.example.demo.repositories.OrderRepository;

@RestController
@RequestMapping(value = RouteMap.ORDER_CONTROLLER)
public class OrderController {
	
	Logger logger = LogManager.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailsService orderDetailsService;

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderDetailsRepository orderDetailsRepo;


	@Autowired
	OrderConverter userOrderConverter;
	@Autowired
	OrderDetailsConverter userOrderDetailsConverter;


	/* Create Order Input --> userOrderDto */
	@RequestMapping(method = RequestMethod.POST,value = RouteMap.ORDER_CONTROLLER_POST_ORDER)
	public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
		if(orderService.createOrder(orderDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/* Create Order Details Input --> userOrderDetailsDto */
	@RequestMapping(method = RequestMethod.POST,value = RouteMap.ORDER_CONTROLLER_POST_ORDER_DETAILS)
	public ResponseEntity<Object> createOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto){
		if(orderDetailsService.createOrderDetails(orderDetailsDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}




	@RequestMapping(value = "/get")
	public OrderDto reateOrder() {
		return userOrderConverter.entityToDto(orderRepo.findAll().get(0));
	}
	@RequestMapping(value = "/get2")
	public OrderDetailsDto reaeOrder() {
		return userOrderDetailsConverter.entityToDto(orderDetailsRepo.findAll().get(0));
	}


}
