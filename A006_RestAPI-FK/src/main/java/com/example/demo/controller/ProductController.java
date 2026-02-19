package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repo.service.CategoryService;
import com.example.demo.repo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CategoryController categoryController;
	
		@Autowired
		ProductService productService;
		
		@Autowired
		CategoryService categoryService;

    ProductController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }
	
		@PostMapping("/category/{id}")
		public ResponseEntity<ProductDto> create(@RequestBody Product pro,@PathVariable int id)
		{
			Category c = categoryService.retrive(id);
			pro.setCategory(c);
			Product createproduct = productService.create(pro);
			
			
			return new ResponseEntity<>(productToDto(createproduct), HttpStatus.OK);
		}
		
		@GetMapping("/")
		public ResponseEntity<List<ProductDto>> list()
		{
			List<Product> products = productService.list();
			List<ProductDto> pros = new ArrayList<>();
			for(Product p : products)
			{
				pros.add(productToDto(p));
			}
			
			return new ResponseEntity<>(pros,HttpStatus.OK);
		}
		
		@GetMapping("/category/{id}")
		public ResponseEntity<List<ProductDto>> catlist(@PathVariable("id") int id)
		{
			
			List<Product> products = productService.catlist(categoryService.retrive(id));
			List<ProductDto> pros = new ArrayList<>();
			for(Product p : products)
			{
				pros.add(productToDto(p));
			}
			
			return new ResponseEntity<>(pros,HttpStatus.OK);
		}
		
		
		public ProductDto productToDto(Product p)
		{
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setPrice(p.getPrice());
			dto.setQty(p.getQty());			
			dto.setCategory(categoryController.categoryToDto(p.getCategory()));
			return dto;
			
			
		}
}
