package com.eshop.demo.dto;

import java.time.LocalDateTime;

import com.eshop.demo.model.Product;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDtoview {
		
		private Long id;		 
		private ProductDto product;
		private Integer qty;
		private LocalDateTime addedAt = LocalDateTime.now();
}
