package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;
	
	@Override
	public Student create(Student st) {
		
		return repo.save(st);
	}

	@Override
	public List<Student> read() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student retrive(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","ID",id));
	}

	@Override
	public Student update(Student st, int id) {
		
		Student std = repo.findById(id).orElseThrow();
		std.setName(st.getName());
		std.setEmail(st.getEmail());
		return repo.save(std);
	}

	@Override
	public void destroy(int id) {
		Student std = repo.findById(id).orElseThrow();
		repo.delete(std);
	}

}
