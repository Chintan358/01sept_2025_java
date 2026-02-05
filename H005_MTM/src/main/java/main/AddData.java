package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Doctor;
import model.Patient;

public class AddData {
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
//		Doctor d = new Doctor();
//		d.setName("Dixa");
//		
//		
//		Patient p = new Patient();
//		p.setName("demo");
//		p.addDoctors(d);
//		
//		Patient p1 = new Patient();
//		p1.setName("sample");
//		p1.addDoctors(d);
		
		
//		Doctor d1 = new Doctor();
//		d1.setName("Darshan");
//		
//		Doctor d2 = new Doctor();
//		d2.setName("Aryan");
//		
//		
//		Patient p1 = new Patient();
//		p1.setName("test");
//		p1.addDoctors(d1);
//		p1.addDoctors(d2);
//		
		
		Patient p = s.find(Patient.class, 4);
		Doctor d = s.find(Doctor.class, 1);
		
		p.addDoctors(d);
	
		
		s.merge(p);
		
		
		
		tx.commit();
		
		
	}
}
