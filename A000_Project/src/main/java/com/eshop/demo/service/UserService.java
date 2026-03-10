package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Role;

public interface UserService {
	
		public UserDto create(UserDto dto);
		public List<UserDto> list();
		public UserDto update(UserDto dto, Long id);
		public List<UserDto> retrivebyrole(Long id );
		public UserDto retrive(Long id);
}
