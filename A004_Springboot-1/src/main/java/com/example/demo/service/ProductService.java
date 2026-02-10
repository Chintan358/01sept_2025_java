package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	
		public void addOrUpdateProduct(Product p);
		public List<Product> products();
		public Product product(int id);
		public void deleteProduct(int id);
}
