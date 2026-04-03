<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
					<form action="upload" method="post" enctype="multipart/form-data">
					<input type="text" name="uname" placeholder="enter username">
					<input type="file" name="image">
					<input type="submit">
					</form>
					
					
					<br>
					<hr>
					<br>
					
					<table>
					<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Image</th>
					</tr>
					
					<%
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/upload","root","root");
					PreparedStatement ps = cn.prepareStatement("select * from user");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{ %>
						<tr>
						<td><%=rs.getInt(1) %></td>
						<td><%=rs.getString(2) %></td>
						<td><img src="img/<%=rs.getString(3) %>" alt="<%=rs.getString(3) %>" width="50px" height="50px"></td>
						</tr>
					<%}
					
					%>
					
					</table>
</body>
</html>