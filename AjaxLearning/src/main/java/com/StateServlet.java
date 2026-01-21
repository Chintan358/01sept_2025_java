package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/states")
public class StateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid = Integer.parseInt(req.getParameter("cid"));
		PrintWriter pw = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/28aug_2025_java","root","root");

			PreparedStatement ps = cn.prepareStatement("select * from state where country_id=?");
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
			
			String options = "<option>---Select State---</option>";
			while(rs.next())
			{
				options+="<option value='"+rs.getInt(1)+"'>"+rs.getString(3)+"</option>";
			}
			pw.append(options);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
}
