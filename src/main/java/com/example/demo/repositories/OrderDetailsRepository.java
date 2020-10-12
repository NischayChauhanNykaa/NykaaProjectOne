package com.example.demo.repositories;

import com.example.demo.models.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserOrderDetails;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<UserOrderDetails, Long>{
    List<UserOrderDetails> findByUserOrder(UserOrder order);
}
