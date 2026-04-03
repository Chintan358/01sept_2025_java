package com.eshop.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.demo.dto.CategoryDto;
import com.eshop.demo.dto.ProductDto;
import com.eshop.demo.service.CategoryService;
import com.eshop.demo.service.ImageService;
import com.eshop.demo.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product API", description = "Manage products and images")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService pservice;
	
	@Autowired
	CategoryService cservice;
	
	@Autowired
	ImageService imageService;
	
	@Value("${project.image}")
	String path;
	
	@PostMapping("/")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto, @RequestParam("cat") Long cid) {
		dto.setCategory(cservice.retrive(cid));
		ProductDto created = pservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> list() {
		List<ProductDto> dtos = pservice.list();
		dtos.stream().map(p->{
			p.setImage("localhost:8080/products/image/"+p.getImage());
			return p;
		}).collect(Collectors.toList());
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> retrive(@PathVariable("id") Long id) {
		ProductDto p = pservice.retrive(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto, @PathVariable("id") Long id,@RequestParam("cat") Long cid) {
		dto.setCategory(cservice.retrive(cid));
		ProductDto updated = pservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<String> destroy(@PathVariable("pid") Long id) {
		pservice.destroy(id);
		return ResponseEntity.ok("Product deleted");
	}
	
	@PostMapping("/image/{pid}")
	public ResponseEntity<ProductDto> uploadImage(@PathVariable("pid") Long pid,@RequestParam("file") MultipartFile file)
	{
		System.out.println(path);
		ProductDto dto = pservice.retrive(pid);
		String filename = imageService.uploadImage(path, file);
		dto.setImage(filename);
		
		 ProductDto updated =  pservice.update(dto, pid);
		 return new ResponseEntity<>(updated,HttpStatus.CREATED);
	
	}
	
	
	@GetMapping("/image/{imageName}")
	public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {

	    String fullPath = path + File.separator + imageName;

	    byte[] image = Files.readAllBytes(Paths.get(fullPath));

	    // detect file type
	    String contentType = Files.probeContentType(Paths.get(fullPath));

	    return ResponseEntity
	            .ok()
	            .contentType(MediaType.parseMediaType(contentType))
	            .body(image);
	}
	
	
}
