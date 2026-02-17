package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="category")
@Getter
@Setter
public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		int id;
		
		@Column(name="cname")
		String name;
		
		@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
		List<Product> products;
}
