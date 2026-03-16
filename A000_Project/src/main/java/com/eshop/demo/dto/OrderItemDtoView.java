package com.eshop.demo.dto;

import java.math.BigDecimal;

import com.eshop.demo.model.Order;
import com.eshop.demo.model.Product;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDtoView {
	
		
	    private Long id;
	    private ProductDto product;
	    private Integer qty;
	    private BigDecimal price;
}
