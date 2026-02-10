package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void addOrUpdateProduct(Product p) {
		// TODO Auto-generated method stub
		productRepo.save(p);
	}

	@Override
	public List<Product> products() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product product(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}

}
