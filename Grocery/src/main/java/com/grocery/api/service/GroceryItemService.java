package com.grocery.api.service;

import java.util.List;

//GroceryItemService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.api.customexception.GroceryItemNotFoundException;
import com.grocery.api.entity.GroceryItem;
import com.grocery.api.repository.GroceryItemRepository;

@Service
public class GroceryItemService {
	@Autowired
	private GroceryItemRepository groceryItemRepository;

	public List<GroceryItem> getAllItems() {
		return groceryItemRepository.findAll();
	}

	public GroceryItem getItemById(Long id) {
		return groceryItemRepository.findById(id).orElseThrow(() -> new GroceryItemNotFoundException(id));
	}

	public GroceryItem addItem(GroceryItem item) {
		return groceryItemRepository.save(item);
	}

	public GroceryItem updateItem(Long id, GroceryItem newItem) {
		GroceryItem existingItem = getItemById(id);
		existingItem.setName(newItem.getName());
		existingItem.setPrice(newItem.getPrice());
		existingItem.setQuantity(newItem.getQuantity());
		return groceryItemRepository.save(existingItem);
	}

	public void deleteItem(Long id) {
		GroceryItem item = getItemById(id);
		groceryItemRepository.delete(item);
	}

	public void updateInventory(Long id, int quantity) {
		GroceryItem item = getItemById(id);
		item.setQuantity(item.getQuantity() + quantity);
		groceryItemRepository.save(item);
	}
}
