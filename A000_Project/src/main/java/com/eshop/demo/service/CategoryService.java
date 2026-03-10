package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.CategoryDto;

public interface CategoryService {
	public CategoryDto create(CategoryDto dto);
	public List<CategoryDto> list();
	public CategoryDto retrive(Long id);
	public CategoryDto update(CategoryDto dto, Long id);
	public void destroy(Long id);
}
