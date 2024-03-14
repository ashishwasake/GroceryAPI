package com.grocery.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.api.customexception.ItemNotFoundException;
import com.grocery.api.entity.GroceryItem;
import com.grocery.api.repository.GroceryItemRepository;

@Service
public class AdminService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem newItem) {
        GroceryItem existingItem = groceryItemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
        existingItem.setName(newItem.getName());
        existingItem.setPrice(newItem.getPrice());
        // Update other fields as needed
        return groceryItemRepository.save(existingItem);
    }

    public void manageInventory(Long itemId, int quantityChange) {
        GroceryItem item = groceryItemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
        item.setQuantity(item.getQuantity() + quantityChange);
        groceryItemRepository.save(item);
    }
}
