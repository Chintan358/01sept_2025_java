package com.eshop.demo.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eshop.demo.model.User;
import com.eshop.demo.repo.UserRepo;

@Service
public class CustomeUSerDetailService implements UserDetailsService {
	
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
	               
		 return new org.springframework.security.core.userdetails.User(
	                user.getUsername(),
	                user.getPassword(),
	                user.getRoles().stream()
	                        .map(role -> new SimpleGrantedAuthority(role.getRole()))
	                        .collect(Collectors.toList())
	        );
	}

}
