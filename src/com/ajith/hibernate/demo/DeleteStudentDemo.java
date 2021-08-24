package com.ajith.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajith.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session  session=factory.getCurrentSession();
		try{

			int studentId=6;	
			//operation 1
			session=factory.getCurrentSession(); 
			session.beginTransaction();
			
			System.out.println("getting student with id: "+studentId);
			
			Student MyStudent =session.get(Student.class, studentId);
			
//			session.delete(MyStudent);
			session.createQuery("delete from Student where id=5" ).executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally{
			factory.close();
		}
	}

}
