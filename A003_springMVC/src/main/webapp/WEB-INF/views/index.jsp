<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reg</title>
</head>
<body>
					<form:form action="addUser" method="post" modelAttribute="user">
						<form:hidden path="id"/>
					<form:label path="name"></form:label>
					<form:input path="name"/>
					<form:label path="email"></form:label>
					<form:input path="email"/>
					<input type="submit">
					</form:form>
					
					<br>
					<br>
					<hr>
					<br>
					
					<table border="1">
					<tr>
					 <th>Id</th>
					 <th>Name</th>
					 <th>Email</th>
					 <th colspan="2">Action</th>
					</tr>
					
					<c:forEach var="dt" items="${data}">
					
					<tr>
					<td>${dt.getId() }</td>
					<td>${dt.getName() }</td>
					<td>${dt.getEmail() }</td>
					<td><a href="delete?id=${dt.getId()}">Delete</a></td>
					<td><a href="edit?id=${dt.getId()}">Edit</a></td>
							
					</tr>
					
					</c:forEach>
					</table>
</body>
</html>