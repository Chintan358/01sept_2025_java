package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		String name;
		double price;
		int qty;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		
		
		
}
