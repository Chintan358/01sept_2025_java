package com.eshop.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	
		@PreAuthorize("hasRole('USER')")
		@PostMapping("/")
		public ResponseEntity<CartItemDto> create(@RequestBody CartItemDto dto,@RequestParam("product") Long Id,HttpServletRequest req)
		{
			dto.setProduct(productService.retrive(Id));
			
			HttpSession session = req.getSession();
			String username =  (String) session.getAttribute("user");
			
			UserDto user = service.byUsername(username);
			
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
		
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/")
		public ResponseEntity<CartDto> retrive(HttpServletRequest req)
		{
			HttpSession session = req.getSession();
			String username =  (String) session.getAttribute("user");
			
			UserDto user = service.byUsername(username);
			CartDto c =  cartService.cartByUser(mapper.map(user, User.class));
		
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		
}
