package com.eshop.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Role;
import com.eshop.demo.model.User;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.UserRepository;
import com.eshop.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public UserDto create(UserDto dto) {
		
		User user = mapper.map(dto, User.class);
		User createdUser =  repository.save(user);
		return mapper.map(createdUser, UserDto.class);
	}

	@Override
	public List<UserDto> list() {
		
		List<User> all = repository.findAll();
//		List<UserDto> dtos  = new ArrayList<>();
//		for(User u : all)
//		{
//			dtos.add(mapper.map(u, UserDto.class));
//		}
		
		List<UserDto> dtos = all.stream().map(u->{
			return mapper.map(u, UserDto.class);
		}).collect(Collectors.toList());
				
				
		return dtos;
	}

	@Override
	public UserDto update(UserDto dto, Long id) {
		
		User u = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
		u.setName(dto.getName());
		u.setEmail(dto.getEmail());
		u.setPassword(dto.getPassword());
		u.setRole(mapper.map(dto.getRole(), Role.class));
		
		return mapper.map(repository.save(u), UserDto.class);
	}

}
