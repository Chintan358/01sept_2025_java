package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
