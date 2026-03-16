package com.eshop.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.eshop.demo.model.Address;
import com.eshop.demo.model.OrderItem;
import com.eshop.demo.model.OrderStatus;
import com.eshop.demo.model.PaymentType;
import com.eshop.demo.model.User;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
		
	 
	    private Long id;
	    private UserDto user;
	    private AddressDto address;
	    private PaymentType paymentType;
	    private String paymentId;
	    private BigDecimal totalAmount;
	    private OrderStatus orderStatus = OrderStatus.PENDING;
	    private LocalDateTime createdAt = LocalDateTime.now();
	    private List<OrderItemDtoView> items;
}
