<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
				<form:form action="addstudent" method="post" modelAttribute="st">
				<form:hidden path="id"/>
				<form:label path="name">Name</form:label>
				<form:input path="name"/>
				<form:label path="email">Email</form:label>
				<form:input path="email"/>
				<input type="submit">
				</form:form>
				
				<br>
				<br>
				
				<table border="1">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th colspan="2">Action</th>
				</tr>
				
				<c:forEach items="${students}" var="st">
				
				<tr>
				<td>${st.getId()}</td>
				<td>${st.getName() }</td>
				<td>${st.getEmail()}</td>
				<td><a href="edit?id=${st.getId()}">Edit</a></td>
				<td><a href="delete?id=${st.getId()}">Delete</a></td>
				</tr>
				</c:forEach>
				
				
				</table>
</body>
</html>