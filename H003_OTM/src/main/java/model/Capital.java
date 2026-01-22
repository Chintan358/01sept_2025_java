package model;

import jakarta.persistence.*;

@Entity
@Table(name="capital")
public class Capital {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		int id;
		
		@Column(name="name")
		String name;
		
		@OneToOne(mappedBy = "capital",cascade = CascadeType.ALL)
		Country country;

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

		public Country getCountry() {
			return country;
		}

		public void setCountry(Country country) {
			this.country = country;
		}
		
		
}
