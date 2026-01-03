package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email =req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User u = new User();
		u.setEmail(email);
		u.setPass(pass);
		
		UserDao dao = new UserDao();
		User exist =  dao.loginCheck(u);
		if(exist==null)
		{
			req.setAttribute("err", "Invalid credentials");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", exist);
			req.setAttribute("user", exist.getName());
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}
		
	}
}
