package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session  session=factory.getCurrentSession();
		try{

			int studentId=2;	
			//operation 1
			session=factory.getCurrentSession(); 
			session.beginTransaction();
			
			System.out.println("getting student with id: "+studentId);
			
			Student MyStudent =session.get(Student.class, studentId);
			
			System.out.println("updating students....");
			MyStudent.setFirstName("aji");
		
			session.getTransaction().commit();
			
			//operation 2
			session=factory.getCurrentSession(); 
			session.beginTransaction();
			
			session.createQuery("update Student set email='kk@gmail.com' where id=3").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally{
			factory.close();
		}
	}

}
