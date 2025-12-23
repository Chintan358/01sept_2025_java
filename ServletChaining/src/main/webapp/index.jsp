<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
			<%-- <%
			String user = (String)request.getAttribute("user");
			if(user!=null){ %>
				<%=user%>
			<%}
			%> --%>
			
			${user}
			<form action="reg" method="post">
			<input type="text" name="name" placeholder="Enter name">
			 <input type="text" name="emial" placeholder="Enter email">
			 <input type="submit">
			</form>
</body>
</html>