<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
		<form action="reg" method="post">
		${msg}
		<input type="text" name="name" placeholder="enter name">
		<input type="text" name="email" placeholder="enter email">
		<input type="text" name="phone" placeholder="Enter phone">
		<input type="submit">
		</form>
</body>
</html>