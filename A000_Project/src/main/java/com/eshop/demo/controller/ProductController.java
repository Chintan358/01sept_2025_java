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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.CategoryDto;
import com.eshop.demo.dto.ProductDto;
import com.eshop.demo.service.CategoryService;
import com.eshop.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService pservice;
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto, @RequestParam("cat") Long cid) {
		dto.setCategory(cservice.retrive(cid));
		ProductDto created = pservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> list() {
		List<ProductDto> dtos = pservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> retrive(@PathVariable("id") Long id) {
		ProductDto p = pservice.retrive(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto, @PathVariable("id") Long id,@RequestParam("cat") Long cid) {
		dto.setCategory(cservice.retrive(cid));
		ProductDto updated = pservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<String> destroy(@PathVariable("pid") Long id) {
		pservice.destroy(id);
		return ResponseEntity.ok("Product deleted");
	}
}
