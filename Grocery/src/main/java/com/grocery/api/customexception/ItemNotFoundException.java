package com.grocery.api.customexception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long itemId) {
        super("Grocery item with ID " + itemId + " not found.");
    }
}
