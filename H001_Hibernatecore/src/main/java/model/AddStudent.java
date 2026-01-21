package model;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	public static void main(String[] args) {
		
		
		
		Student st = new Student();
		st.setId(2);;
		st.setName("Aryan1");
		st.setEmail("aryan1@gmail.com");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
//		s.persist(st);  //add
//	s.merge(st);    //update
		
		tx.commit();
		
		
	}
}
