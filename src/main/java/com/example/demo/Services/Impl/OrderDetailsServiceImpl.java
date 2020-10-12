package com.example.demo.Services.Impl;

import com.example.demo.Converter.OrderDetailsConverter;
import com.example.demo.Services.Structure.OrderDetailsService;
import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.OrderDetailsDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.repositories.OrderDetailsRepository;
import com.example.demo.repositories.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    OrderDetailsConverter orderDetailsConverter;

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
}
