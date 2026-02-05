package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="doctor")
public class Doctor {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	@ManyToMany
	@JoinTable(
			name = "dr_pr",
			joinColumns =@JoinColumn(name="did"),
			inverseJoinColumns = @JoinColumn(name="pid")			
	)
	List<Patient> patients;
	
	
	
	public void addPatient(Patient p)
	{
		if(patients==null)
		{
			patients = new ArrayList<Patient>();
			
		}
		patients.add(p);
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



	public List<Patient> getPatients() {
		return patients;
	}



	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	
	
	
	
}
