package com.eshop.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="role")
@Getter
@Setter
public class Role {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String role;
	
	@ManyToMany
	@JoinTable(
			
			name = "role_user",
			joinColumns = @JoinColumn(name="rid"),
			inverseJoinColumns = @JoinColumn(name="uid")
			
   )
	List<User> users;
}
