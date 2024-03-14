package com.grocery.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grocery.api.entity.GroceryItem;
import com.grocery.api.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-item")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
        GroceryItem newItem = adminService.addGroceryItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    @GetMapping("/view-items")
    public List<GroceryItem> viewAllGroceryItems() {
        return adminService.getAllGroceryItems();
    }

    @DeleteMapping("/remove-item/{itemId}")
    public ResponseEntity<?> removeGroceryItem(@PathVariable Long itemId) {
        adminService.removeGroceryItem(itemId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-item/{itemId}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem newItem) {
        GroceryItem updatedItem = adminService.updateGroceryItem(itemId, newItem);
        return ResponseEntity.ok().body(updatedItem);
    }

    @PutMapping("/manage-inventory/{itemId}/{quantityChange}")
    public ResponseEntity<?> manageInventory(@PathVariable Long itemId, @PathVariable int quantityChange) {
        adminService.manageInventory(itemId, quantityChange);
        return ResponseEntity.ok().build();
    }
}
