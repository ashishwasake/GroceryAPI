package com.grocery.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.api.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}