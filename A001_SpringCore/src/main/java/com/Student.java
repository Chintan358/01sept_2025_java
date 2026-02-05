package com;

import java.util.List;
import java.util.Set;

public class Student {
		
	int id;
	String name;
	String email;
	List<String> subjects;
	Set<String> lang;
	Address address;
	List<Marks> marks;
	
	
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Set<String> getLang() {
		return lang;
	}
	public void setLang(Set<String> lang) {
		this.lang = lang;
	}
	
	
	
	public void display()
	{
		System.out.println(id+" "+name+" "+email);
		System.out.println("***subject***");
		for(String s : subjects)
		{
			System.out.println(s);
		}
		
		System.out.println("***languages***");
		for(String s : lang )
		{
			System.out.println(s);
		}
		
		System.out.println("***address****");
		address.display();
		
		System.out.println("***marks***");
		for(Marks m : marks)
		{
			m.display();
		}
	}
	
}	
