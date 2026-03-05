package com.eshop.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	Long id;
	String name;
	String email;
	String password;
	RoleDto role;
	
}
