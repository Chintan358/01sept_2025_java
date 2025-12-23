package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

import dao.StudentDao;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		Student st = new Student();
		st.setName(name);
		st.setEmail(email);
		st.setPhone(phone);
		
		StudentDao dao = new StudentDao();
		int i = dao.addStudent(st);
		if(i>0)
		{
			req.setAttribute("msg", "Regostration successfully");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
	}

}
