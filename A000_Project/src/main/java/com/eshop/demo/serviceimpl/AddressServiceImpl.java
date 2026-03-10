package com.eshop.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.model.Address;
import com.eshop.demo.model.User;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.AddressRepository;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.UserService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserService service;
	
	@Override
	public AddressDto create(AddressDto address) {
		
		Address adr =  mapper.map(address, Address.class);
		return mapper.map(repository.save(adr), AddressDto.class);
	}

	@Override
	public List<AddressDto> list() {
		
		List<Address> all = repository.findAll();
		List<AddressDto> dtos = all.stream().map(adr->{
			return mapper.map(adr, AddressDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public AddressDto retrive(Long id) {
		
		Address adr = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "Id", id));
		
		return mapper.map(adr, AddressDto.class);
	}

	@Override
	public AddressDto update(AddressDto dto, Long id) {
		
		Address adr = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "Id", id));
		adr.setAddressLine(dto.getAddressLine());
		adr.setCity(dto.getCity());
		adr.setCountry(dto.getCountry());
		adr.setPincode(dto.getPincode());
		adr.setState(dto.getState());
		adr.setDefault(dto.isDefault());
		
		return mapper.map(repository.save(adr), AddressDto.class);
	}

	@Override
	public void delete(Long id) {
		Address adr = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address", "Id", id));
		repository.delete(adr);
		
	}

	@Override
	public List<AddressDto> addressByUser(Long id) {
		
		List<Address> all = repository.findByUser(mapper.map(service.retrivebyrole(id), User.class));
		List<AddressDto> dtos = all.stream().map(adr->{
			return mapper.map(adr, AddressDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
