package com.grocery.api.customexception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long userId) {
		super("User with ID " + userId + " not found.");
	}
}
