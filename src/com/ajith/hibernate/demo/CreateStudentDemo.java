package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session  session=factory.getCurrentSession();
		try{
			System.out.println("Creting new Student object....");
			Student tempStudent=new Student("Ajith","kumar","ajii@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving...");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			System.out.println("Done !");
			
		}finally{
			factory.close();
		}
	}

}
