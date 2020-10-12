package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserOrder;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long> {
	UserOrder findByorderId(long id);
}