package main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Doctor;
import model.Patient;

public class ViewData {
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		

//		List<Doctor> doctors = s.createQuery("from Doctor").list();
//		
//		for(Doctor d : doctors)
//		{
//			System.out.println(d.getId()+" "+d.getName());
//			for(Patient p : d.getPatients())
//			{
//				System.out.println(p.getId()+" "+p.getName());
//			}
//			
//			System.out.println("*******************");
//		}
		
		
		
		
		List<Doctor> doctors = s.createQuery("from Doctor c where c.name='Kanha'").list();
		
		for(Doctor d : doctors)
		{
			System.out.println(d.getId()+" "+d.getName());
			for(Patient p : d.getPatients())
			{
				System.out.println(p.getId()+" "+p.getName());
			}
			
			System.out.println("*******************");
		}
		
		
	}
}
