package com.eshop.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
		
		Long id;
		UserDto user;
		List<CartItemDtoview> items;
		private LocalDateTime createdAt = LocalDateTime.now();
}
