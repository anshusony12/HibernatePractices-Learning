package com.firstlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session s=factory.openSession();
		Student student = s.get(Student.class, 112);
		System.out.println(student);
		
		System.out.println("working something");
		
		Student student2 = s.get(Student.class, 112);
		System.out.println(student2);
	}

}
