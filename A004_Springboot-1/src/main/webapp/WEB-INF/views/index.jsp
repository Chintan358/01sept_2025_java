<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form action="addproduct" method="post" modelAttribute="product">
		<form:hidden path="id"/>
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<form:label path="price">Price</form:label>
		<form:input path="price"/>
		<form:label path="qty">qty</form:label>
		<form:input path="qty"/>
		<input type="submit">
		</form:form>
		
		<br>
		<h1>Product List</h1>
		<table border="1">
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Qty</th>
		<th colspan="2">Action</th>
		</tr>
		<c:forEach var="pro" items="${products}">
		<tr>
		<td>${pro.getId() }</td>
		<td>${pro.getName() }</td>
		<td>${pro.getPrice() }</td>
		<td>${pro.getQty() }</td>
		<td><a href="delete?id=${pro.getId()}">Delete</a></td>
		<td><a href="edit?id=${pro.getId()}">Edit</a></td>
		</tr>
		</c:forEach>
		</table>
</body>
</html>