package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;

public class DeleteData {
	public static void main(String[] args) {
		
		

		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
		        .addAnnotatedClass(Category.class)
		        .buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
	
	//	Country c = s.find(Country.class, 1);
		Category c = s.find(Category.class, 3);
		s.remove(c);
		
		tx.commit();
		
		
		
		
	}
}
