package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.service.CategoryService;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepo categoryRepo;
	
	@Autowired
	CategoryService categoryService;

    CategoryController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody Category c)
	{
		Category created =  categoryService.create(c);
		return new ResponseEntity<>(categoryToDto(created),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> list()
	{
		List<Category> all = categoryService.list();
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category c : all)
		{
			dtos.add(categoryToDto(c));
		}
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	public static CategoryDto categoryToDto(Category c)
	{
		CategoryDto dto = new CategoryDto();
		dto.setId(c.getId());
		dto.setName(c.getName());
		
		return dto;
	}
	
	public static Category dtoToCategory(CategoryDto c)
	{
		Category cat = new Category();
		cat.setId(c.getId());
		cat.setName(c.getName());
		return cat;
	}
		
}
