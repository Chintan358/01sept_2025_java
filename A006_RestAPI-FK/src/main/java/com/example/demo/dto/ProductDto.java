package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	
		int id;
		String name;
		double price;
		int qty;
		CategoryDto category;
		
		
		
}
