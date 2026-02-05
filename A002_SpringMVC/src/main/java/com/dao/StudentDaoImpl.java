package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Student;


@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	SessionFactory factory;

	@Override
	public void addorUpdateStudent(Student student) {
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(student);
		tx.commit();
		
	}

	@Override
	public List<Student> allstudents() {
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Student").list();
	}

	@Override
	public Student studentbyid(int id) {
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Student.class, id);
	}

	@Override
	public void deleteStudent(int id) {
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Student st = s.get(Student.class, id);
		s.delete(st);
		tx.commit();
	}

}
