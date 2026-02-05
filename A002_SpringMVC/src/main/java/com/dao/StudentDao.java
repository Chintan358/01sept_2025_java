package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {
		
		public void addorUpdateStudent(Student student);
		public List<Student> allstudents();
		public Student studentbyid(int id);
		public void deleteStudent(int id);
		
}
