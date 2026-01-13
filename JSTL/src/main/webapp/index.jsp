<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="Hello"></c:out>
	<c:set value="100" var="a"></c:set>
	<c:set value="20" var="b"></c:set>
	<c:out value="${a}"></c:out>
	<c:if test="${100>20}">
	<c:out value="A is greater"></c:out>
	</c:if>
	
	<c:forEach begin="1" end="10" var="dt">
	<c:out value="${dt }"></c:out>
	</c:forEach>
	
	
	
	
</body>
</html>