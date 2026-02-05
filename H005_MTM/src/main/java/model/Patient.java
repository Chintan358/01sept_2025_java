package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		int id;
		
		@Column(name="name")
		String name;
		
		@ManyToMany
		@JoinTable(
				name = "dr_pr",
				joinColumns =@JoinColumn(name="pid"),
				inverseJoinColumns = @JoinColumn(name="did")
				
				)
		List<Doctor> doctors;
		
		public void addDoctors(Doctor d)
		{
			if(doctors==null)
			{
				doctors = new ArrayList<Doctor>();
			}
			doctors.add(d);
		}

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

		public List<Doctor> getDoctors() {
			return doctors;
		}

		public void setDoctors(List<Doctor> doctors) {
			this.doctors = doctors;
		}
		
		
		
}
