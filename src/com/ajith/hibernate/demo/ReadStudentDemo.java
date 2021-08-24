package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session  session=factory.getCurrentSession();
		try{
			System.out.println("Creting new Student object....");
			Student tempStudent=new Student("mani","Mn","Mani@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			System.out.println("saved students. Generate id: "+tempStudent.getId());
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("getting student with id: "+tempStudent.getId());
			
			Student MyStudent =session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: "+MyStudent);
			session.getTransaction().commit();
			System.out.println("Done !");
			
		}finally{
			factory.close();
		}
	}

}
