package com.eshop.demo.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.CartDto;
import com.eshop.demo.model.Cart;
import com.eshop.demo.model.User;
import com.eshop.demo.repo.CartRepository;
import com.eshop.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CartDto create(CartDto dto) {
		
		Cart c = mapper.map(dto, Cart.class);	
		return mapper.map(cartRepository.save(c), CartDto.class);
	}

	@Override
	public CartDto cartByUser(User user) {
		
		CartDto dt = null;
		Cart c = cartRepository.findByUser(user);
		if(c!=null)
		{
			dt = mapper.map(c, CartDto.class);
		}
		return dt;
	}

}
