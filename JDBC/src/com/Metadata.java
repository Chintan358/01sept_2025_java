package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Metadata {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root");
		
//			DatabaseMetaData dm = cn.getMetaData();
//			System.out.println(dm.getDriverName());
//			System.out.println(dm.getDriverVersion());
//			System.out.println(dm.getDatabaseMajorVersion());
//			
			
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			
			ResultSetMetaData rd = rs.getMetaData();
			System.out.println(rd.getColumnCount());
			System.out.println(rd.getColumnTypeName(2));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}
}
