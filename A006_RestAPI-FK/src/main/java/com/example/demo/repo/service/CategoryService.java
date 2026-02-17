package com.example.demo.repo.service;

import java.util.List;

import com.example.demo.model.Category;

public interface CategoryService {
		
			public Category create(Category c);
			public List<Category> list();
			public Category retrive(int cid);
			public Category update(Category c, int id);
			public void destroy(int id);
}
