<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg</title>
</head>
<body>
<form:form action="adduser" method="post" modelAttribute="user">
<form:label path="username">Username</form:label>
<form:input path="username"/>
<form:label path="password">Password</form:label>
<form:input path="password"/>
<input type="submit">
</form:form>
</body>
</html>