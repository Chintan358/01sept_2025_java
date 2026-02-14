package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
		
		@Autowired
		StudentService service;
	
		@PostMapping("/students")
		public ResponseEntity<Student> create(@Valid @RequestBody Student st)
		{
			Student createStudent = service.create(st);
			return new ResponseEntity<>(createStudent,HttpStatus.CREATED);
		}
		
		@GetMapping("/students")
		public ResponseEntity<List<Student>> get()
		{
			List<Student> students = service.read();
			return new ResponseEntity<>(students,HttpStatus.OK);
		}
		
		@GetMapping("/students/{id}")
		public ResponseEntity<Student> retrive(@PathVariable("id") int id)
		{
			Student student = service.retrive(id);
			return new ResponseEntity<>(student,HttpStatus.OK);
		}
		
		@PutMapping("/students/{id}")
		public ResponseEntity<Student> update(@RequestBody Student st,@PathVariable("id") int id)
		{
			Student student = service.update(st, id);
			return new ResponseEntity<>(student,HttpStatus.CREATED);
		}
		
		@DeleteMapping("/students/{id}")
		public ResponseEntity<String> delete(@PathVariable("id") int id)
		{
			service.destroy(id);
			return ResponseEntity.ok("Student deleted");
		}
}
