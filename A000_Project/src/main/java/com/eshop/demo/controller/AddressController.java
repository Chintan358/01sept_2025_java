package com.eshop.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
		@Autowired
		AddressService addressService;
		
		@Autowired
		UserService service;
		
		@Autowired
		ModelMapper mapper;

		@PostMapping("/")
		public ResponseEntity<AddressDto> create(@RequestBody AddressDto dto, @RequestParam("user") Long uid)
		{
			dto.setUser(service.retrive(uid));
			AddressDto created =  addressService.create(dto);
			return new ResponseEntity<>(created,HttpStatus.OK);
		}
}
