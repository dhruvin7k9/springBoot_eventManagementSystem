<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Details</title>
<style>
	body {
		font-family: 'Courier New', Courier, monospace;
		font-size: large;
	}
	table {
  		border-collapse: collapse;
  		width: 90%;
		position: relative;
		left: 4vw;
	}
	th, td {
  		text-align: left;
  		padding: 8px;
	}
	th {
		color: blue;
	}
	td {
		font-weight: bolder;
		font-size: larger;
		
	}
	tr:nth-child(even) {
  		background-color: #D6EEEE;
	}
	a {
		font-weight: bold;
		z-index: 100;
	}
	a:hover {
		color: green;
	}
	.msg {
		color: tomato;
		text-align: center;
	}
</style>
</head>
<body>
<em>
<h1>Event Name : ${event.eventName}</h1>
<h3>Description : ${event.eventDescription}</h3>
<h3>Registration due : ${event.eventRegDue}</h3>
</em>
<hr> <br/>
<c:choose>
	<c:when test='${status == "empty"}'>
		<h3 class="msg">no students participated yet !</h3>
	</c:when>
	<c:otherwise>
        <h4>List of students</h4>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>CollegeID</th>
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
<br/>
<a href="showClubDashboard?clubName=${clubName}">DASHBOARD</a> 
</body>
</html>