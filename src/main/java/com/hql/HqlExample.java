package com.hql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HqlExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		String query="from Student where name='Puneet'";
		
		Session s=factory.openSession();
		Query q=s.createQuery(query);
		
		List<Student> list= q.list();
		
		for(Student stud:list) {
			System.out.println(stud.getName()+" : "+stud.getCerti().getCourse());
		}
		
		System.out.println("............................................................................");
		
		Transaction tx=s.beginTransaction();
//		Query q2=s.createQuery("delete from Student s where s.city=:c");
//		q2.setParameter("c", "noha");
//		int r=q2.executeUpdate();
//		
//		System.out.println(r+"deleted");
//		
		Query q3=s.createQuery("update Student set city=:c where name=:n");
		q3.setParameter("c", "Delhi");
		q3.setParameter("n", "John");
		int r=q3.executeUpdate();
		System.out.println(r+" updated successfully");
		tx.commit();
		
		
//		how to execute join
		Query q4=s.createQuery("select q.question, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object[]> list2=q4.getResultList();
		  
		for(Object [] arr: list2) {
			
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		factory.close();
	}
	
}
