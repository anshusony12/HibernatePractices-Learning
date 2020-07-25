package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HqlPegination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session =factory.openSession();
		
		Query query=session.createQuery("from Student");
		
		query.setFirstResult(0);
		query.setMaxResults(4);
		
		List<Student> list= query.list();
		
		for(Student st: list) {
			System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
		}
		
		session.close();
		
		factory.close();
		
		
	}

}
