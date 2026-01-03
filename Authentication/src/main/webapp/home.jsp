<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>


<%
	User u = (User)session.getAttribute("user");
	if(u==null)
	{
		request.setAttribute("err", "Please login first");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>
<h1>WELCOME, ${user}</h1>
<a href="logout">Logout</a>
</body>
</html>