package com.eshop.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.CategoryDto;
import com.eshop.demo.model.Category;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.CategoryRepository;
import com.eshop.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CategoryDto create(CategoryDto dto) {
		Category cat = mapper.map(dto, Category.class);
		repo.save(cat);
		return mapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> list() {
		List<Category> clist = repo.findAll();
		List<CategoryDto> dtos = clist.stream().map(c->{
			return mapper.map(c, CategoryDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CategoryDto retrive(Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		return mapper.map(c, CategoryDto.class);
	}

	@Override
	public CategoryDto update(CategoryDto dto, Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		c.setName(dto.getName());
		c.setDescription(dto.getDescription());
		c.setCreatedAt(dto.getCreatedAt());
		return mapper.map(repo.save(c), CategoryDto.class);
	}

	@Override
	public void destroy(Long id) {
		Category c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","ID",id));
		repo.delete(c);
	}

}
