package com.grocery.api.customexception;

public class GroceryItemNotFoundException extends RuntimeException {
    public GroceryItemNotFoundException(Long id) {
        super("Grocery item with ID " + id + " not found.");
    }
}
