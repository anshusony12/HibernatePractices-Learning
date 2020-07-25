package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class emDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1= new Student();
		student1.setId(111);
		student1.setName("Puneet");
		student1.setCity("Pulwama");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android");
		certificate1.setDuration("3 months");
		student1.setCerti(certificate1);
		
		Student student2= new Student();
		student2.setId(112);
		student2.setName("John");
		student2.setCity("Rampur");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Python");
		certificate2.setDuration("2 months");
		student2.setCerti(certificate2);
		
		Student student3= new Student();
		student3.setId(1312);
		student3.setName("playboy");
		student3.setCity("noha");
		
		Certificate certificate3 = new Certificate();
		certificate3.setCourse("java");
		certificate3.setDuration("4 months");
		student3.setCerti(certificate3);
		//System.out.println(certificate3.getCourse());
		
		org.hibernate.Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//object save
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		tx.commit();
		session.close();

		
		factory.close();
	}
}
