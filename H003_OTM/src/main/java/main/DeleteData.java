package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Capital;
import model.Country;

public class DeleteData {
	public static void main(String[] args) {
		
		

		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Country.class)
		        .addAnnotatedClass(Capital.class)
		        .buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
	
	//	Country c = s.find(Country.class, 1);
		Capital c = s.find(Capital.class, 3);
		s.remove(c);
		
		tx.commit();
		
		
		
		
	}
}
