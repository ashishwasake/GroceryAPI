package com.grocery.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.api.entity.Order;
import com.grocery.api.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	 List<Order> findByUser(User user);
}
