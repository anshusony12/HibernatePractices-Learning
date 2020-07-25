package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
//		creating student
		Student st = new Student();
		st.setId(105);
		st.setName("Durgesh");
		st.setCity("Faridabad");
		System.out.println(st);
		
//		creating object of address class
		
		Address ad=new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(11212.112);
		
		//reading image
		FileInputStream fis= new FileInputStream("src/main/java/com/tut/SmartKart.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		org.hibernate.Session session =factory.openSession();
		//
		Transaction tx=session.beginTransaction();
		session.save(st);
		session.save(ad);	
		
		tx.commit();
		session.close();
		
		System.out.println("done...");
	}
	
}
