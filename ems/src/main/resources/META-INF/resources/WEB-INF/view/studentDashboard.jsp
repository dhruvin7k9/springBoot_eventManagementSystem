<%@page import="springBoot.ems.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
</head>
<body>
	<h2 style="text-align:center;"> student dashboard </h2>
	<%@ include file="studentOngoingEvents.jsp" %>
	<a href="participatedEvents">participated events</a>
</body>
</html>