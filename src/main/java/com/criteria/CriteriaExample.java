package com.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

import net.sf.ehcache.config.ConfigError;
import net.sf.ehcache.search.expression.Criteria;

public class CriteriaExample {
	public static void main(String[] args) {
		Session session= new Configuration().configure().buildSessionFactory().openSession();
		org.hibernate.Criteria c=session.createCriteria(Student.class);
		c.add(Restrictions.eq("city", "Kanpur"));
		List<Student> students=c.list();
		for(Student s:students) {
			System.out.println(s);
		}
		session.close();
	}
}
