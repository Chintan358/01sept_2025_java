package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/reg")
public class RegController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String gender = req.getParameter("gender");
		String lang[] = req.getParameterValues("lang");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		
		String lng = "";
		for(String l  :lang)
		{
			lng=lng+l+",";
		}
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPass(pass);
		user.setGender(gender);
		user.setLang(lng);
		user.setCountry(country);
		user.setAddress(address);
		
		UserDao dao = new UserDao();
		
		if(dao.isEmailExist(email))
		{
			req.setAttribute("err", "Email alredy exist !!!");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		
		}
		else {
			int  i = dao.addUser(user);
			if(i>0)
			{
				req.setAttribute("msg", "Registration successfully !!!");
				req.getRequestDispatcher("reg.jsp").forward(req, resp);
			}
		}
		
		
	}
}
