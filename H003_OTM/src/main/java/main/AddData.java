package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Capital;
import model.Country;

public class AddData {
	public static void main(String[] args) {
		
		
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		cfg.addAnnotatedClass(Country.class);
//		cfg.addAnnotatedClass(Capital.class);	
//		SessionFactory sf = cfg.buildSessionFactory();
		
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Country.class)
		        .addAnnotatedClass(Capital.class)
		        .buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Capital c = new Capital();
		c.setName("Sidny");
		
		Country c1 = new Country();
		c1.setName("Australia");
		c1.setCapital(c);
		
		s.persist(c);
		s.persist(c1);
		
		
		tx.commit();
		
		
		
		
	}
}
