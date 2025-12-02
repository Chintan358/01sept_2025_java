package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudent {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name : ");
		String name = sc.next();
		System.out.println("Enter email :");
		
		String email= sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root");
			
			
			Statement st = cn.createStatement();
			
//			int i = st.executeUpdate("insert into student values(0,'Naitik','naitik@gmail.com')");
			
			int i = st.executeUpdate("insert into student values(0,'"+name+"','"+email+"')");
			
			if(i>0)
			{
				System.out.println("Data inserted");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
