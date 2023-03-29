<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Club</title>
</head>
<body>
	<form action="createClub" method="post">
		<span> Club Name : </span> <input type="text" name="clubName" />
		<br /> <br /> 
		<span> Club Password : </span> 
		<input type="password" name="clubPassword" />
		<br /> <br /> 
		<span> Confirm Password : </span> 
		<input type="password" name="cclubPassword" />
		<input type="submit" value="submit" />
	</form>
</body>
</html>