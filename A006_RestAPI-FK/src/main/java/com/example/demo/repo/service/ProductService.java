package com.example.demo.repo.service;

import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.Product;

public interface ProductService {
		
			public Product create(Product c);
			public List<Product> list();
			public Product retrive(int cid);
			public Product update(Product c, int id);
			public void destroy(int id);
}
