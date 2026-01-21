package model;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ViewStudent {
	public static void main(String[] args) {
		
		
		
	
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		//Student st =  s.find(Student.class, 1);
		//System.out.println(st.getId()+" "+st.getName()+" "+st.getEmail());
		
		
		List<Student> st = s.createQuery("from Student").list();
		
		for(Student std : st)
		{
			System.out.println(std.getId()+" "+std.getName()+" "+std.getEmail());
		}
		
	}
}
