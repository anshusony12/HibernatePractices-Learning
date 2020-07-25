package cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadingDemo {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Question q1 = new Question();
		q1.setQuestionId(33232);
		q1.setQuestion("What is Cascading?");
		
		Answer a1=new Answer();
		a1.setAnswerId(1111);
		a1.setAnswer("Cascading first answer");
		a1.setQuestion(q1);
		
		Answer a2=new Answer();
		a2.setAnswerId(10000);
		a2.setAnswer("Cascading second  answer");
		a2.setQuestion(q1);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		
		q1.setAnswers(list);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(q1);
		
		
		tx.commit();
		
		s.close();
		factory.close();
	}
}
