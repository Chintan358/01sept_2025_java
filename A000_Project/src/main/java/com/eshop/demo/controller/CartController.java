package com.eshop.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.CartDto;
import com.eshop.demo.dto.CartItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.User;
import com.eshop.demo.service.CartItemService;
import com.eshop.demo.service.CartService;
import com.eshop.demo.service.ProductService;
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
		
		@Autowired
		ProductService productService;
		
		@Autowired
		CartItemService cartItemService;
	
		@PostMapping("/")
		public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto,@RequestParam("product") Long Id)
		{
			dto.setProduct(productService.retrive(Id));
			
			UserDto user = service.retrive(2l);
			
			CartDto isExist =   cartService.cartByUser(mapper.map(user, User.class));
			if(isExist==null)
			{
				CartDto ct = new CartDto();
				ct.setUser(user);
				isExist =  cartService.create(ct);
			}
			
			dto.setCart(isExist);
			
			CartItemDto created =  cartItemService.create(dto);
			
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		}
		
		@GetMapping("/")
		public ResponseEntity<CartDto> retrive()
		{
			UserDto user = service.retrive(2l);
			CartDto c =  cartService.cartByUser(mapper.map(user, User.class));
		
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		
}
