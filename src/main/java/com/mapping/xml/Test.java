package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
	    Person p=new Person(55,"Anshu","delhi","66666");
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

}
