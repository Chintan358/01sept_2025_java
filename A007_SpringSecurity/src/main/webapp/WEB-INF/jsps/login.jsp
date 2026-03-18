<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>


<form method="post" action="/doLogin">

    <!-- ✅ CSRF TOKEN (MANDATORY) -->
    <input type="hidden" 
           name="${_csrf.parameterName}" 
           value="${_csrf.token}" />

    <label>Username:</label>
    <input type="text" name="username" /><br><br>

    <label>Password:</label>
    <input type="password" name="password" /><br><br>

    <button type="submit">Login</button>
</form>
</body>
</html>