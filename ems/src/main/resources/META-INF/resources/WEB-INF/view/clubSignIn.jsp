<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Club Sign In</title>
</head>
<body>
	<form action="validateClub" method="post">
		<span> Club Name : </span> <input type="text" name="clubName" />
		<br /> <br /> 
		<span> Club Password : </span> 
		<input type="password" name="clubPassword" />
		<input type="submit" value="submit" />
	</form><br/>
    <c:if test="${not empty msg}">
    <h5 style="color:red;"> ${msg} </h5>
    </c:if>
	<a href="createClubForm">create a club</a>
</body>
</html>