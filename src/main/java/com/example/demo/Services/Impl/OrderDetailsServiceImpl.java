package com.example.demo.Services.Impl;

import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderService {

    @Autowired
    OrderService orderService;


    @Override
    public boolean createOrder(OrderDto orderDto) {


        return false;
    }

}
