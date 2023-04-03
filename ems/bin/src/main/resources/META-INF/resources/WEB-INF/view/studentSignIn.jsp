<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Sign In</title>
</head>
<body>
	<h2>Student Sign In</h2>
	<form action="validateStudent" method="post">
	<span>Student Id : </span>
	<input type="text" name="studentId"/>
	<br/><br/><span>Student Password : </span>
	<input type="password" name="studentPassword"/>
	<input type="submit" value="submit"/>
	</form>
	<c:if test="${not empty msg}">
		<h5 style="color:red;"> ${msg} </h5>
	</c:if>
	<a href="registerStudent">register student</a>
</body>
</html>