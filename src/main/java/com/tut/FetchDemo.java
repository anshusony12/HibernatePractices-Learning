package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
//	get, load
	public static void main (String args[]) {
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
		
	Session session = factory.openSession();
//	get-student:105
	Student student=(Student)session.load(Student.class, 105);
	System.out.println(student);
	
	Address ad=(Address)session.get(Address.class, 1);
	System.out.println(ad.getCity());
	session.close();
	factory.close();
	
	}
}
