package com.ajith.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session  session=factory.getCurrentSession();
		try{
			
			session.beginTransaction();
			
			List<Student>theStudents=session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			theStudents=session.createQuery("from Student s where s.lastName='A'").list();
			
			System.out.println("\n\nwho have lastName of A");
			displayStudents(theStudents);
			
			theStudents=session.createQuery("from Student s where "+ "s.lastName='A' "
					+ "OR s.firstName='Krish'").list();
			System.out.println("\n\nwho have lastName of A");
			displayStudents(theStudents);


			session.getTransaction().commit();

			System.out.println("Done !");
			
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}
