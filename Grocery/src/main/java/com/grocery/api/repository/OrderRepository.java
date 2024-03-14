package com.grocery.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
