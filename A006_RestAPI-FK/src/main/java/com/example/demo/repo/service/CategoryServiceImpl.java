package com.example.demo.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public Category create(Category c) {
		
		return categoryRepo.save(c);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Category retrive(int cid) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category", "ID", cid));
	}

	@Override
	public Category update(Category c, int id) {
		
	    Category cd =  categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "ID", id));
	    cd.setName(c.getName());
		return categoryRepo.save(cd) ;
	}

	@Override
	public void destroy(int id) {
		 Category cd =  categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "ID", id));
		 
		 categoryRepo.delete(cd);
	}

}
