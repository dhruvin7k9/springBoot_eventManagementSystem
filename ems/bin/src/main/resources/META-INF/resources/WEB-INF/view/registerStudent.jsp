<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addStudent" method="post">
		<span>Name : </span>
		<input type="text" name="studentName"/>
		<span>Branch : </span>
		<input type="text" name="studentBranch"/>
		<span>Semester : </span>
		<input type="number" name="studentSem"/>
		<span>Id : </span>
		<input type="text" name="studentId"/>
		<span>Password : </span>
		<input type="password" name="studentPassword"/>
		<input type="submit" value="submit"/>
	</form>
	<c:if test="${not empty msg}">
		<h5 style="color:red;"> ${msg} </h5>
	</c:if><br/>
	<a href="signIn">student sign in</a>
</body>
</html>