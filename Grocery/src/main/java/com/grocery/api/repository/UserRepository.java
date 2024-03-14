package com.grocery.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
