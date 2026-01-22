package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Capital;
import model.Country;

public class ViewData {
	public static void main(String[] args) {
		
		

		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Country.class)
		        .addAnnotatedClass(Capital.class)
		        .buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		
//		Country c = s.find(Country.class, 1);
//		System.out.println(c.getId()+" "+c.getName()+" "+c.getCapital().getName());
//		
		
		List<Capital> caps = s.createQuery("from Capital").list();
		for(Capital c : caps)
		{
			System.out.println(c.getId()+" "+c.getName()+" "+c.getCountry().getName());
		}
		
		tx.commit();
		
		
		
		
	}
}
