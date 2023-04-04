<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Club</title>
<style>
	body {
		font-family: 'Courier New', Courier, monospace;
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
	  background-color: #4CAF50;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	  font-size: medium;
	}
	
	input[type=submit]:hover {
	  background-color: #45a049;
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
		top: 65vh;
		left: 2vw;
	}
</style>
</head>
<body>
	<h1>Club Registration</h1>
	<div>
	<form action="createClub" method="post">
		<p>=> Have a Fascinating Idea</p> 
		<p>OR</p>
		<p>=> Want to Unite Everyone in Your Story </p>
		<p><em><b>Create a Community of Like Minded Ones Now!</b></em></p>
		<span><b> Club Name : </b></span> <input type="text" name="clubName" required/>
		<br /> <br /> 
		<span><b> Club Password : </b></span> 
		<input type="password" name="clubPassword" required/>
		<br /> <br />
		<input type="submit" value="submit" />
	</form>
	</div>
	<br/>
	<c:if test="${not empty msg}">
		<h5 style="color:red; top:7vh;">(${msg})</h5>
	</c:if><br/>
	<a href="signIn">club sign in</a>
	<br/>
	<a style="top:70vh;" href="/">HOME</a>
</body>
</html>