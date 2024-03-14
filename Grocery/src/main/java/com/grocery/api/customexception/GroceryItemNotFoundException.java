package com.grocery.api.customexception;

public class GroceryItemNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GroceryItemNotFoundException(Long id) {
        super("Grocery item with ID " + id + " not found.");
    }
}
