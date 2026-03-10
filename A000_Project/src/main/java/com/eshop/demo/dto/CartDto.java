package com.eshop.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
		
		Long id;
		UserDto user;
		private LocalDateTime createdAt = LocalDateTime.now();
}
