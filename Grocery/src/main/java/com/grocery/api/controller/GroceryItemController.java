package com.grocery.api.controller;

import java.util.ArrayList;
import java.util.List;

//GroceryItemController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.api.entity.GroceryItem;
import com.grocery.api.service.GroceryItemService;

@RestController
@RequestMapping("/api/admin/grocery")
public class GroceryItemController {
 @Autowired
 private GroceryItemService groceryItemService;

 @GetMapping("/items")
 public List<GroceryItem> getAllItems() {
     return groceryItemService.getAllItems();
 }

 @GetMapping("/{id}")
 public ResponseEntity<GroceryItem> getItemById(@PathVariable Long id) {
     GroceryItem item = groceryItemService.getItemById(id);
     return ResponseEntity.ok().body(item);
 }

 @PostMapping
 public ResponseEntity<GroceryItem> addItem(@RequestBody GroceryItem item) {
     GroceryItem newItem = groceryItemService.addItem(item);
     return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
 }

 @PutMapping("/{id}")
 public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
     GroceryItem updatedItem = groceryItemService.updateItem(id, item);
     return ResponseEntity.ok().body(updatedItem);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteItem(@PathVariable Long id) {
     groceryItemService.deleteItem(id);
     return ResponseEntity.ok().build();
 }
 
 @PostMapping("/create")
 public ResponseEntity<List<GroceryItem>> createOrder(@RequestBody List<GroceryItem> items) {
     List<GroceryItem> createdItems = new ArrayList<>();
     for (GroceryItem item : items) {
         GroceryItem newItem = groceryItemService.addItem(item);
         createdItems.add(newItem);
     }
     return ResponseEntity.status(HttpStatus.CREATED).body(createdItems);
 }

}
