package com.grocery.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.api.entity.User;
import com.grocery.api.service.UserService;

@RestController
public class RegistrationController {
	private final UserService userService;

	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public void registerUser(@RequestBody User user) {
		userService.registerUser(user);
	}
}
