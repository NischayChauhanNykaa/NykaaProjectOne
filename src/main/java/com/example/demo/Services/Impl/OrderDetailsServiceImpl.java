package com.example.demo.Services.Impl;

import com.example.demo.Converter.MyOrdersConverter;
import com.example.demo.Converter.OrderDetailsConverter;
import com.example.demo.Services.Structure.OrderDetailsService;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.DetailDto;
import com.example.demo.dto.OrderDetailsDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.models.UserOrder;
import com.example.demo.models.UserOrderDetails;
import com.example.demo.repositories.OrderDetailsRepository;
import com.example.demo.repositories.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    OrderDetailsConverter orderDetailsConverter;
    @Autowired
    MyOrdersConverter myOrdersConverter;

    Logger logger = LogManager.getLogger(OrderDetailsService.class);


    @Override
    public boolean createOrderDetails(OrderDetailsDto orderDetailsDto) {
        if(orderDetailsDto ==null)
            return false;

        try {
            orderDetailsRepository.save( orderDetailsConverter.dtoToEntity(orderDetailsDto) );
            return true;
        } catch (Exception e) {
            logger.error("Error while saving "+e.getMessage());
        }
        return false;
    }

    @Override
    public List<DetailDto> getOrderDetails(UserOrder userOrder) {
        try {
            List<UserOrderDetails> orderDetails = orderDetailsRepository.findByUserOrder(userOrder);
            if(orderDetails == null) {
                logger.error("Order details with order Id {} not found", userOrder.getOrderId());
                throw new Exception("Order details not found for order id " + userOrder.getOrderId());
            }
            return myOrdersConverter.toDetailDto(orderDetails);
        } catch (Exception e) {
            logger.error("Error while fetching order details: " + e.getMessage());
            return null;
        }
    }


}
