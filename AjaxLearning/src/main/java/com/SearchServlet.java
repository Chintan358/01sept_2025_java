package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String q = req.getParameter("q");
		PrintWriter pw = resp.getWriter();			
		String data="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root");

			Statement st  =cn.createStatement();
			
			data+= "<ul>";
			ResultSet rs = st.executeQuery("select * from products where name like '"+q+"%'");
			while(rs.next())
			{
				data+="<li>"+rs.getString(2)+"</li>";
			}
			data+="</ul>";

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		if(q.equals("electric"))
//		{
//			data="<ul><li>Fan</li><li>TV</li><li>Fridge</li></ul>";
//		}
//		else if(q.equals("cloths"))
//		{
//			data="<ul><li>Shirt</li><li>tshirt</li><li>cap</li></ul>";
//		}
//		else if(q.equals("sports"))
//		{
//			data="<ul><li>Bat</li><li>Ball</li><li>stump</li></ul>";
//		}
//		else
//		{
//			data = "no data found";
//		}
		
		pw.append(data);
	}
}
