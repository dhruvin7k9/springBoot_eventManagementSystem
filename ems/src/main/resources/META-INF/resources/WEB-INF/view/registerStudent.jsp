<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		font-family:system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
		font-size: large;
	}
	input[type=text], select {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	input[type=submit] {
	  width: 100%;
	  background-color: #233da5;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	  font-size: medium;
	}
	
	input[type=submit]:hover {
	  background-color: #2621b4;
	}
	
	div {
	  position: absolute;
	  left: 20vw;
	  top: 15vh;
	  width: 50%;
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}
	h1,h5 {
		position: absolute;
		left: 2vw;
	}
	a {
		position: absolute;
		font-weight: bolder;
		top: 70vh;
		left: 2vw;
	}
</style>
</head>
<body>
	<h1>Student Register</h1>
	<div>
	<form action="addStudent" method="post">
		<span>Name : </span>
		<input type="text" name="studentName" required/>
		<br/>
		<span>Branch : </span>
		<input type="text" name="studentBranch" required/>
		<br/><br/>
		<span>Semester : </span>
		<input type="number" name="studentSem" required/>
		<br/> <br/>
		<span>Id : </span>
		<input type="text" name="studentId" required/>
		<br/> <br/>
		<span>Password : </span>
		<input type="password" name="studentPassword" required/>
		<br/> <br/>
		<input type="submit" value="submit"/>
	</form>
	</div>
	<c:if test="${not empty msg}">
		<h5 style="color:red; top:7vh;"> (${msg}) </h5>
	</c:if><br/>
	<a href="signIn">student sign in</a>
	<a style="top:75vh;" href="/">HOME</a>
</body>
</html>