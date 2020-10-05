package com.example.demo.Controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.RouteMap;
import com.example.demo.models.UserOrder;
import com.example.demo.repositories.OrdersRepository;

@RestController
@RequestMapping(value = RouteMap.ORDER_CONTROLLER)
public class OrderController {
	
	@Autowired
	private OrdersRepository orderRepository;
	
	Logger logger = LogManager.getLogger(OrderController.class);

	
	/* Create Order Input --> userOrder */
	@RequestMapping(value = RouteMap.ORDER_CONTROLLER_SET_ORDER)
	public void createOrder(@RequestBody UserOrder userOrder) {
		if(userOrder==null)
			return;
		
		// Convert from DTO	
		try {
			orderRepository.save(userOrder);
		} catch (Exception e) {
			logger.error("Error while saving "+e.getMessage());
		}
		
	}
}
