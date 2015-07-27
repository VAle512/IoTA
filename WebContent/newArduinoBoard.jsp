<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>New ARD</title>
</head>
<body>
	<h1>Insert new Arduino Board</h1>
	<form action="<c:url value="/controller/arduinoBoard.create" />"
		method="get">
		<div>
			CODE: <input type="text" name="arduinoBoardCode"
				value="${arduinoBoard.code}" /> ${arduinoCodeErr}
		</div>
		<div>
			<input type="submit" name="sumbit" value="invia" />
		</div>
	</form>
</body>
</html>
