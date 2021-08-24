package com.krish.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {

		
		String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try{
			System.out.println("connecting to Database:"+jdbcurl);
			Connection myCon=DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("connection Successful !!!");
			
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
