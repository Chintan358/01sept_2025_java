package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudent {
		
		public static void main(String[] args) {
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id : ");
			int id = sc.nextInt();
			System.out.println("enter name : ");
			String name = sc.next();
			System.out.println("Enter email :");
			String email= sc.next();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection cn = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root");
				
				String sql = "update student set name=?,email=? where id=?";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, name);
				st.setString(2, email);
				st.setInt(3, id);
				
				int i = st.executeUpdate();
				if(i>0)
				{
					System.out.println("student updated");
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
