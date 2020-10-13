package com.example.demo.Controllers;


import com.example.demo.Converter.OrderDetailsConverter;
import com.example.demo.Services.Structure.OrderDetailsService;
import com.example.demo.dto.*;
import com.example.demo.models.User;
import com.example.demo.models.UserOrder;
import com.example.demo.models.UserOrderDetails;
import com.example.demo.repositories.OrderDetailsRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Constants.RouteMap;
import com.example.demo.Converter.OrderConverter;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.repositories.OrderRepository;

import java.util.List;

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
		try {
			if(orderDetailsService.createOrderDetailsTM(orderDetailsDto)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("My Error occurred for Transactions "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/* Create Order and Order Details Input --> userOrderDetailsDto */
	@RequestMapping(method = RequestMethod.POST,value = RouteMap.ORDER_CONTROLLER_POST_ORDER_DETAILS_TRANSACTION)
	public ResponseEntity<Object> createOrderAndOrderDetails(@RequestBody FullOrderDto fullOrderDto){
		try {
			if(orderDetailsService.createOrderAndOrderDetailsTM(fullOrderDto)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("My Error occurred for Transactions "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}



	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> getOrder(@PathVariable long id) {
		logger.log(Level.INFO,"Request received at Order with GET");
		ResponseDto responseDto = orderService.fetch(id);
		HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
		return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
	}

	// Constants
	@GetMapping("/myOrders")
	public ResponseEntity<ResponseDto> getByUser(@RequestBody User user) {
		logger.log(Level.INFO,"Request received at Order with GET");
		ResponseDto responseDto = orderService.getByUser(user);
		HttpStatus status = HttpStatus.resolve(responseDto.getHttpStatus());
		return new ResponseEntity<>(responseDto, status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
	}











	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<Object> reateOrder(@PathVariable int id) {
		UserOrder userOrder = orderRepo.findByOrderId(id);
		OrderDto orderDto = userOrderConverter.entityToDto(userOrder);

		List<UserOrderDetails> orderDetails = orderDetailsRepo.findByUserOrder(userOrder);
		FullOrderDto fullOrderDto = new FullOrderDto(orderDto,userOrderDetailsConverter.entityToDto(orderDetails));

		return new ResponseEntity<>(fullOrderDto,HttpStatus.ACCEPTED);
	}






}
