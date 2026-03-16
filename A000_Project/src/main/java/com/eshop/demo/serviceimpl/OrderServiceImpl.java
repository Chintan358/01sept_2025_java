package com.eshop.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.OrderDto;
import com.eshop.demo.dto.OrderItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Order;
import com.eshop.demo.model.OrderItem;
import com.eshop.demo.model.User;
import com.eshop.demo.repo.OrderItemRepository;
import com.eshop.demo.repo.OrderRepository;
import com.eshop.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository itemRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public OrderDto create(OrderDto dto) {
		
		Order created = orderRepository.save(mapper.map(dto, Order.class));
		return mapper.map(created, OrderDto.class);
	}

	@Override
	public OrderItemDto create(OrderItemDto dto) {
		
		OrderItem created = itemRepository.save(mapper.map(dto, OrderItem.class));
		return mapper.map(created, OrderItemDto.class);
	}

	@Override
	public List<OrderDto> list(UserDto dto) {
		
		List<Order> orders = orderRepository.findByUser(mapper.map(dto, User.class));
		List<OrderDto> items = 
				orders.stream().map(ord->{
					return mapper.map(ord,OrderDto.class);
				}).collect(Collectors.toList());
				
		return items;
	}

}
