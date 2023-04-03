<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Club</title>
</head>
<body>
	<h2>Club Registration</h2>
	<form action="createClub" method="post">
		<span> Club Name : </span> <input type="text" name="clubName" />
		<br /> <br /> 
		<span> Club Password : </span> 
		<input type="password" name="clubPassword" />
		<br /> <br />
		<input type="submit" value="submit" />
	</form>
	<c:if test="${not empty msg}">
		<h5 style="color:red;"> ${msg} </h5>
	</c:if><br/>
	<a href="signIn">club sign in</a>
	<br/>
	<a href="/">home</a>
</body>
</html>