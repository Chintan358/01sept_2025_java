package com.eshop.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.CartDto;
import com.eshop.demo.dto.CartItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.User;
import com.eshop.demo.service.CartService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
		@Autowired
		CartService cartService;
		
		@Autowired
		UserService service;
		
		@Autowired
		ModelMapper mapper;
	
		@PostMapping("/")
		public void create(@RequestBody CartItemDto dto,@RequestParam("user") Long Id)
		{
			
			UserDto user = service.retrive(Id);
			
			CartDto isExist =   cartService.cartByUser(mapper.map(user, User.class));
			if(isExist==null)
			{
				CartDto ct = new CartDto();
				ct.setUser(user);
				isExist =  cartService.create(ct);
			}
			
			dto.setCart(isExist);
			
		}
}
