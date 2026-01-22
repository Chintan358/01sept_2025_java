package model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		int id;
		
		@Column(name="name")
		String name;
		
		@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
		List<Product> products;
		
		
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

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		
		
}
