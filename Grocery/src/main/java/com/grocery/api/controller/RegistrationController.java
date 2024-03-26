package com.grocery.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@PostMapping("/api/register")
	public void registerUser(@RequestBody User user) {
		userService.registerUser(user);
	}
	
	 @PostMapping("/api/admin/createAdmin")
	    public ResponseEntity<String> createAdmin(@RequestBody User admin) {
	        // Get the authentication object
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        // Check if user is authenticated and has admin role (ROLE_ADMIN)
	        if (authentication != null && authentication.isAuthenticated()
	                && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
	            // Set the role of the user to ADMIN
	            admin.setRole("ADMIN");
	            userService.registerUser(admin);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Admin created successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized to create admin");
	        }
	    }
}
