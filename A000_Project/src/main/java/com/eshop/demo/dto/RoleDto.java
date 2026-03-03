package com.eshop.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
	Long id;
	String name;
	LocalDateTime createdAt;
}
