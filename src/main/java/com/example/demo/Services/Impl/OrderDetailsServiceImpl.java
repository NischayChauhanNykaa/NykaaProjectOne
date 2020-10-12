package com.example.demo.Services.Impl;

import com.example.demo.Services.Structure.OrderService;
import com.example.demo.dto.OrderDto;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderService {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository ordersRepository;

    @Override
    public boolean createOrder(OrderDto orderDto) {


        return false;
    }

}
