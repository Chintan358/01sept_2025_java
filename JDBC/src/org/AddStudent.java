package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			
			PreparedStatement st = cn.prepareStatement("insert into student values(?,?,?)");
			st.setInt(1, 0);
			st.setString(2, name);
			st.setString(3, email);
			
			int i = st.executeUpdate();
			
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
