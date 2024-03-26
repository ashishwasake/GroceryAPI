package com.grocery.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.api.entity.Order;
import com.grocery.api.service.OrderService;

@RestController
@RequestMapping("/api/user/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestBody List<Long> itemIds) {
		// Check if user is authenticated
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			// User is authenticated, create the order
			Order order = orderService.createOrder(itemIds);
			return ResponseEntity.status(HttpStatus.CREATED).body(order);
		} else {
			// User is not authenticated, return unauthorized status
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
		Order order = orderService.getOrderById(id);
		return ResponseEntity.ok().body(order);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
		List<Order> userOrders = orderService.getUserOrders(userId);
		return ResponseEntity.ok().body(userOrders);
	}

	@GetMapping("/user/{userId}/history")
	public ResponseEntity<List<Order>> getUserOrderHistory(@PathVariable Long userId) {
		List<Order> userOrderHistory = orderService.getUserOrderHistory(userId);
		return ResponseEntity.ok().body(userOrderHistory);
	}

}
