package com.grocery.api.customexception;

public class ItemNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(Long itemId) {
        super("Grocery item with ID " + itemId + " not found.");
    }
}
