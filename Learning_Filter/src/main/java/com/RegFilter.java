package com;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class RegController
 */
@WebFilter("/reg")
public class RegFilter extends HttpFilter implements Filter {
       
   @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	
	   String name = request.getParameter("name");
	   String email = request.getParameter("email");
	   String phone = request.getParameter("phone");
	   
	   RequestDispatcher rd = request.getRequestDispatcher("reg.jsp");
	   if(name.equals("") || name.equals(null))
	   {
		   request.setAttribute("nameErr", "Name Required !!!");
		   rd.forward(request, response);
	   }
	   
	   
	   if(email.equals("") || email.equals(null))
	   {
		   request.setAttribute("emailErr", "Email Required !!!");
			  
		   rd.forward(request, response);
	   }
	   
	   if(phone.equals("") || phone.equals(null))
	   {
		   request.setAttribute("phoneErr", "Phone Required !!!");
			  
		   rd.forward(request, response);
	   }
	   
	   
	   
	   chain.doFilter(request, response);
	   
}

}
