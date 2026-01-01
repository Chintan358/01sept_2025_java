<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="reg">
			
			<input type="text" name="name" placeholder="Enter name"
			value="<%=request.getParameter("name")!=null?request.getParameter("name"):"" %>"
			
			>
			<br>
			<span>${nameErr}</span>
			<br>
			<input type="text" name="email" placeholder="Enter Email"

value="<%=request.getParameter("email")!=null?request.getParameter("email"):"" %>"
>
			<br>
			<span>${emailErr}</span>
			<br>
			<input type="text" name="phone" placeholder="Enter Phone"
			value="<%=request.getParameter("phone")!=null?request.getParameter("phone"):"" %>"
			
			>
		<br>
			<span>${phoneErr}</span>
			<br>
		
		<input type="submit">			
			</form>
</body>
</html>