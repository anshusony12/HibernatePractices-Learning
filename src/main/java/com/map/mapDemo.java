package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");

		// creating answer
		Answer a1 = new Answer();
		a1.setAnswerId(234);
		a1.setAnswer("java is programming language.");
		a1.setQuestion(q1);

		Answer a2 = new Answer();
		a2.setAnswerId(323);
		a2.setAnswer("java is very secure language ");
		a2.setQuestion(q1);

		Answer a3 = new Answer();
		a3.setAnswerId(3434);
		a3.setAnswer("java is very secure language ");
		a3.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

//		saving data
		Question q=(Question)session.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		
		for(Answer a: q.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		
		tx.commit();
		
		session.close();
		factory.close();
	}

}
