package com.eshop.demo.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		String username;
		String password;
		
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(
				
				name = "role_user",
				joinColumns = @JoinColumn(name="uid"),
				inverseJoinColumns = @JoinColumn(name="rid")
				
	   )
		List<Role> roles;
		
}
