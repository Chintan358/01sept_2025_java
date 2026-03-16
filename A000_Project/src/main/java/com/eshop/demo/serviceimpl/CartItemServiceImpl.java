package com.eshop.demo.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.CartItemDto;
import com.eshop.demo.model.CartItem;
import com.eshop.demo.repo.CartItemRepository;
import com.eshop.demo.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public CartItemDto create(CartItemDto dto) {
		
		
		CartItem item = mapper.map(dto, CartItem.class);
		CartItem created = cartItemRepository.save(item);
		return mapper.map(created, CartItemDto.class);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cartItemRepository.deleteById(id);
	}

}
