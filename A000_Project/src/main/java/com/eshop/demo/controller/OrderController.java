package com.eshop.demo.controller;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.dto.CartDto;
import com.eshop.demo.dto.CartItemDto;
import com.eshop.demo.dto.CartItemDtoview;
import com.eshop.demo.dto.OrderDto;
import com.eshop.demo.dto.OrderItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Cart;
import com.eshop.demo.model.User;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.CartItemService;
import com.eshop.demo.service.CartService;
import com.eshop.demo.service.OrderService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
		@Autowired
		UserService service;
		
		@Autowired
		AddressService addressService;
		
		@Autowired
		OrderService orderService;
		
		@Autowired
		CartService cartService;
		
		@Autowired
		ModelMapper mapper;
	
		@Autowired
		CartItemService cartItemService;
		
		@PostMapping("/")
		public void create(@RequestBody OrderDto dto,@RequestParam("address") Long aid)
		{
			AddressDto address = addressService.retrive(aid);
			UserDto user = service.retrive(2l);
			dto.setUser(user);
			dto.setAddress(address);
			
			OrderDto createdOrder =  orderService.create(dto);
			CartDto cart = cartService.cartByUser(mapper.map(user, User.class));
			
			OrderItemDto odto = new OrderItemDto();
			for(CartItemDtoview cartitem : cart.getItems()) 
			{
				odto.setOrder(createdOrder);
				odto.setProduct(cartitem.getProduct());
				odto.setQty(cartitem.getQty());
				odto.setPrice(cartitem.getProduct().getPrice());
				
				orderService.create(odto);
				
				cartItemService.delete(cartitem.getId());
			}
			cartService.delete(cart.getId());	
		}
		
		@GetMapping("/")
		public ResponseEntity<List<OrderDto>> list()
		{
			UserDto dto = service.retrive(2l);
			List<OrderDto> all =  orderService.list(dto);
			
			return new ResponseEntity<>(all,HttpStatus.OK);
		}
}
