package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class StudentDao {
	
	SessionFactory sf = null;
	public StudentDao() {
			
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				cfg.addAnnotatedClass(Student.class);	
			    sf = cfg.buildSessionFactory();	
	}
	

	public int addStudent(Student st)
	{
		int i =0;
		try {
			
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.persist(st);
			tx.commit();
			i = 1;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	public ArrayList<Student> viewStudents()
	{
		ArrayList<Student> al = null;
		
		try {
			
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			al = (ArrayList<Student>) s.createQuery("from Student").list();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return al;
		
	}
	
	
	
	
	public int deleteStudent(int id)
	{
		int i=0;
		
		try {
			
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			Student st = s.find(Student.class, id);
			s.remove(st);
			tx.commit();
			i = 1;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}


	public Student getStudentById(int eid) {
		
		Student st = new Student();
		try {
			
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			 st = s.find(Student.class, eid);
			
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}


	public int updateStudent(Student st) {
		
		int i =0;
		try {
			
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.merge(st);
			tx.commit();
			i = 1;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
