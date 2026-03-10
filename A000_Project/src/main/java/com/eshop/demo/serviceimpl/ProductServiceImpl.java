package com.eshop.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.repo.ProductRepository;
import com.eshop.demo.dto.ProductDto;
import com.eshop.demo.model.Product;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.ProductRepository;
import com.eshop.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public ProductDto create(ProductDto dto) {
		Product pro = mapper.map(dto, Product.class);
		repo.save(pro);
		return mapper.map(pro, ProductDto.class);
	}

	@Override
	public List<ProductDto> list() {
		List<Product> plist = repo.findAll();
		List<ProductDto> dtos = plist.stream().map(p->{
			return mapper.map(p, ProductDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public ProductDto retrive(Long id) {
		Product p = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","ID",id));
		return mapper.map(p, ProductDto.class);
	}

	@Override
	public ProductDto update(ProductDto dto, Long pid) {
		Product p = repo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Product","ID",pid));
		p.setName(dto.getName());
		p.setDescription(dto.getDescription());
		p.setPrice(dto.getPrice());
		p.setStockQty(dto.getStockQty());
		p.setImage(dto.getImage());
		return mapper.map(repo.save(p), ProductDto.class);
	}

	@Override
	public void destroy(Long pid) {
		Product p = repo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Product","ID",pid));
		repo.delete(p);
	}

}
