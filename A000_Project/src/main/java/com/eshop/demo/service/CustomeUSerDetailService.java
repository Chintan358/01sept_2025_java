package com.eshop.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eshop.demo.model.User;
import com.eshop.demo.repo.UserRepository;

@Service
public class CustomeUSerDetailService implements UserDetailsService {
	
		@Autowired
		UserRepository repo;

	    @Override
	    public UserDetails loadUserByUsername(String username) {
	        User user = repo.findByName(username)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	          List<SimpleGrantedAuthority> authorities = 
	        		  new ArrayList<>();
	          authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
	        		
	        return new org.springframework.security.core.userdetails.User(
	                user.getName(),
	                user.getPassword(),
	                authorities
	        );
	    }

}
