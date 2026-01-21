package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		Student st = new Student();
		st.setId(id);
		st.setName(name);
		st.setEmail(email);
		st.setPhone(phone);
		
		StudentDao dao = new StudentDao();
		int i = dao.updateStudent(st);
		
		if(i>0)
		{
			req.setAttribute("msg", "update successfully");
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int eid = Integer.parseInt(req.getParameter("eid"));
		
		StudentDao dao = new StudentDao();
		Student st =  dao.getStudentById(eid);
		req.setAttribute("student", st);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
		
	}
}
