package com.example.demo.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Override
	public Product create(Product c) {
		// TODO Auto-generated method stub
		return productRepo.save(c);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product retrive(int cid) {
		// TODO Auto-generated method stub
		return productRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("Product", "ID", cid));

	}

	@Override
	public Product update(Product c, int id) {
		Product p= productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		    p.setName(c.getName());
			return productRepo.save(p) ;
	}

	@Override
	public void destroy(int id) {
	productRepo.deleteById(id);
		
	}

	


}
