<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Club Dashboard</title>
</head>
<body>
<h1>club Dashboard</h1>
<h3>club name : ${clubName}</h3>
<br/>
<a href="addEvent?clubName=${clubName}">add Event</a>
<hr>
<c:choose>
	<c:when test='${status == "empty"}'>
		<h3>add events</h3>
	</c:when>
	<c:otherwise>
        <h3>List of events</h3>
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
				<c:forEach var="e" items="${events}">
					<tr>
						<td>${e.eId}</td>
						<td>${e.eventName}</td>
						<td>${e.eventDescription}</td>
						<td>${e.eventRegDue}</td>
						<td>
						<a href="eventDetails?clubName=${clubName}&eId=${e.eId}">Details</a>
						&nbsp;
						<a href="eventDelete?clubName=${clubName}&eId=${e.eId}" 
						   onclick="return confirm('Do you really want to cancel this event?')">Cancel</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<br/>
<hr>
<a href="/">home</a>
</body>
</html>