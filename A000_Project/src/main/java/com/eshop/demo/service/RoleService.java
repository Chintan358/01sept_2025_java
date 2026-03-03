package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.RoleDto;
import com.eshop.demo.model.Role;

public interface RoleService {
	
		public RoleDto create(RoleDto dto);
		public List<RoleDto> list();
		public RoleDto retrive(Long id);
		public RoleDto update(RoleDto dto, Long id);
		public void delete(Long id);
		
}
