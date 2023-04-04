<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Club Dashboard</title>
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
	td {
		font-weight: 500;
	}
	th, td {
  		text-align: center;
  		padding: 8px;
	}

	tr:nth-child(even) {
  		background-color: #D6EEEE;
	}
	a {
		font-weight: bold;
	}
	a:hover {
		color: green;
	}
</style>
</head>
<body>
<h1>Club Dashboard</h1>
<h3><em> club name : ${clubName}</em></h3>
<br/>
<a href="addEvent?clubName=${clubName}">Organize an event</a>
<br/>
<br/>
<hr> <br/>
<c:choose>
	<c:when test='${status == "empty"}'>
		<h3 style="text-align: center; color: tomato;">Let's interact with everyone by organizing an event.</h3>
	</c:when>
	<c:otherwise>
        <h3>Organized events :</h3>
		<table cellpadding="5" cellspacing="5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Registration Due</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${liveEvents}">
					<tr>
						<td>${e.eId}</td>
						<td>${e.eventName}</td>
						<td>${e.eventDescription}</td>
						<td>${e.eventRegDue}</td>
						<td>
						<a href="eventDetails?clubName=${clubName}&eId=${e.eId}">Details</a>
						&nbsp;
						<a href="updateEvent?clubName=${clubName}&eNm=${e.eventName}">Update</a>
						&nbsp;
						<a href="eventDelete?clubName=${clubName}&eId=${e.eId}" style="color: red;"
						   onclick="return confirm('Do you really want to cancel this event?')">Cancel</a>
						</td>
					</tr>
				</c:forEach>
				<c:forEach var="e" items="${expiredEvents}">
					<tr>
						<td>${e.eId}</td>
						<td>${e.eventName}</td>
						<td>${e.eventDescription}</td>
						<td>${e.eventRegDue}</td>
						<td>
						<a href="eventDetails?clubName=${clubName}&eId=${e.eId}">Details</a>
						&nbsp;
						<span style="color:grey">Update</span>
						&nbsp;
						<span style="color:grey">Cancel</span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<br/>
<hr>
<br/>
<a style="position: absolute; left: 4vw;" href="/">LogOut</a>
</body>
</html>