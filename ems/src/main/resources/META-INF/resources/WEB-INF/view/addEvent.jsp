<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add Event</title>
</head>
<body>
<h2>Add Event : </h2>
<form method="POST" name="add_event"
		action="processNewEvent?clubName=${clubName}">
			Event name: <input name="eventName" type="text" required/> 
			<br /> <br />
			Event Description: <input name="eventDescription" type="text" required/> 
			<br /> <br /> 
			Last registration date: <input name="eventRegDue" type="datetime-local" required/> 
			<br /> <br />
		<input value="AddEvent" type="submit" />
	</form>
</body>
</html>