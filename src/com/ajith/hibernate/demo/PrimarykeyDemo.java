package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Student;

public class PrimarykeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creting 3 Student object....");
			Student tempStudent1 = new Student("krish", "ak", "krish@gmail.com");
			Student tempStudent2 = new Student("raj", "A", "Raj@gmail.com");
			Student tempStudent3 = new Student("Dhaya", "D", "Dhaya@gmail.com");

			session.beginTransaction();

			System.out.println("Saving...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			session.getTransaction().commit();
			System.out.println("Done !");

		} finally {
			factory.close();
		}
	}

}
