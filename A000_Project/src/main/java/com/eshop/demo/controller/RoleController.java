package com.eshop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.RoleDto;
import com.eshop.demo.model.Role;
import com.eshop.demo.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	RoleService service;
	
	@PostMapping("/")
	public ResponseEntity<RoleDto> create(@RequestBody RoleDto dto)
	{
		RoleDto createdRole = service.create(dto);
		return new ResponseEntity<>(createdRole,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<RoleDto>> list()
	{
		List<RoleDto> roles = service.list();
		return new ResponseEntity<>(roles,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleDto> retrive(@PathVariable("id") Long id)
	{
		RoleDto role = service.retrive(id);
		return new ResponseEntity<>(role,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleDto> update(@RequestBody RoleDto dto,@PathVariable("id") Long id)
	{
		RoleDto role = service.update(dto, id);
		return new ResponseEntity<>(role,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id)
	{
		service.delete(id);
		return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
	}
	
	
}
