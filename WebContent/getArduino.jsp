<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>Arduino Board Selection</title>
</head>
<body>
<h1>Select an Arduino Board via ID</h1>
	<form action="<c:url value="/controller/arduinoBoard.get" />" method="get">
	<div>ID: <input type="text" name="arduinoBoardId" value="${arduinoBoard.id}"/> ${arduinoIdErr}</div>
	<div><input type="submit" name="sumbit" value="submit" /></div>
	</form>
</body>
</html> 