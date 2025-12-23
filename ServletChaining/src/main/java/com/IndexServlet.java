package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse  resp ) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Registration success</h1>");	
//		req.getRequestDispatcher("index.jsp").include(req, resp);
		req.getRequestDispatcher("demo").include(req, resp);
		
//		req.setAttribute("user", name);
//		req.getRequestDispatcher("index.jsp").forward(req, resp);
//		
		//req.getRequestDispatcher("demo").forward(req, resp);		
		
//		resp.sendRedirect("index.jsp");
		
	}
}
