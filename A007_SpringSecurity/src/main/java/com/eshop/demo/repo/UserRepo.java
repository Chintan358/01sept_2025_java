package com.eshop.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
		public Optional<User> findByUsername(String username);
}
