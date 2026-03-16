package com.eshop.demo.service;

import com.eshop.demo.dto.CartItemDto;

public interface CartItemService {
	
		public CartItemDto create(CartItemDto dto);
		public void delete(Long id);
}
