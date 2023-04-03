<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>event Details</title>
</head>
<body>
<h2>event name : ${event.eventName}</h2>
<h4>description : ${event.eventDescription}</h4>
<h4>due date : ${event.eventRegDue}</h4>
<hr>
<c:choose>
	<c:when test='${status == "empty"}'>
		<h3>no students participated yet !</h3>
	</c:when>
	<c:otherwise>
        <h3>List of students</h3>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>College ID</th>
					<th>Name</th>
					<th>Branch</th>
					<th>Semester</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${students}">
					<tr>
						<td>${s.sId}</td>
						<td>${s.studentId}</td>
						<td>${s.studentName}</td>
						<td>${s.studentBranch}</td>
						<td>${s.studentSem}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<br/>
<hr>
<a href="showClubDashboard?clubName=${clubName}">go to dashboard</a> 
</body>
</html>