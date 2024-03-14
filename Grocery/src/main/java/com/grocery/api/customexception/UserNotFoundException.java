package com.grocery.api.customexception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long userId) {
		super("User with ID " + userId + " not found.");
	}
}
