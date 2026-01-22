package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;

public class AddData {
	public static void main(String[] args) {
		
		

		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
		        .addAnnotatedClass(Category.class)
		        .buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		
//		Category c = new Category();
//		c.setName("Electric");
		
//		Product p1 = new Product();
//		p1.setName("TV");
//		p1.setCategory(c);
//		
//		Product p2 = new Product();
//		p2.setName("Mobile");
//		p2.setCategory(c);
//		
//		s.persist(c);
//		s.persist(p1);
//		s.persist(p2);
		
		
		Category c = s.find(Category.class, 1);
		
		
		Product p1 = new Product();
		p1.setName("Shirt");
		p1.setCategory(c);
		
		Product p2 = new Product();
		p2.setName("tshirt");
		p2.setCategory(c);
		
		s.persist(c);
		s.persist(p1);
		s.persist(p2);
		
//		Category c=  new Category();
//		c.setId(1);
//		c.setName("Cloths");
//		s.merge(c);
		
		tx.commit();
		
		
		
		
	}
}
