package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.model.Address;

public interface AddressService {
		
		public AddressDto create(AddressDto address);
		public List<AddressDto> list();
		public AddressDto retrive(Long id);
		public AddressDto update(AddressDto dto, Long id);
		public void delete(Long id);
		public List<AddressDto> addressByUser(Long id);
}
