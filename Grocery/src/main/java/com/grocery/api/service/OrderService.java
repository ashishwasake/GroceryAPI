package com.grocery.api.service;

import java.util.List;

//OrderService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.api.customexception.OrderNotFoundException;
import com.grocery.api.entity.GroceryItem;
import com.grocery.api.entity.Order;
import com.grocery.api.repository.GroceryItemRepository;
import com.grocery.api.repository.OrderRepository;

@Service
public class OrderService {
 @Autowired
 private OrderRepository orderRepository;

 @Autowired
 private GroceryItemRepository groceryItemRepository;

 public Order createOrder(List<Long> itemIds) {
     List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
     Order order = new Order();
     order.setItems(items);
     return orderRepository.save(order);
 }

 public Order getOrderById(Long id) {
     return orderRepository.findById(id)
             .orElseThrow(() -> new OrderNotFoundException(id));
 }

 // Additional methods for managing user orders

 public List<Order> getUserOrders(Long userId) {
     // Implement logic to retrieve orders for a specific user
 }

 // Other service methods as needed
}

