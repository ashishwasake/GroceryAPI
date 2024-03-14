package com.grocery.api.controller;

import java.util.List;

//OrderController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.api.entity.Order;
import com.grocery.api.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
 @Autowired
 private OrderService orderService;

 @PostMapping("/create")
 public ResponseEntity<Order> createOrder(@RequestBody List<Long> itemIds) {
     Order order = orderService.createOrder(itemIds);
     return ResponseEntity.status(HttpStatus.CREATED).body(order);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
     Order order = orderService.getOrderById(id);
     return ResponseEntity.ok().body(order);
 }

 // Add other endpoints for user functionalities, such as viewing order history, etc.
}

