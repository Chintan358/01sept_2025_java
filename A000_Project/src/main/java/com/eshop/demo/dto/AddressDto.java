package com.eshop.demo.dto;

import com.eshop.demo.model.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	
	 
	    private Long id;
	    private UserDto user;
	    private String addressLine;
	    private String city;
	    private String state;
	    private String pincode;
	    private String country;
	    private boolean isDefault = false;
}
