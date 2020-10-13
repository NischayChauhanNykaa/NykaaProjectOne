package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserOrder;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long> {
	UserOrder findByorderId(long id);

	UserOrder findByOrderId(long id);

	List<UserOrder> findByUser(User user);
}