<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>New TEMP</title>
</head>
<body>
	<form action="<c:url value="/controller/temperature.create" />" method="get">
	<div>ID: <input type="text" name="arduinoBoardId" value="${arduinoBoard.id}"/> </div>
	<div>VALUE: <input type="text" name="temperatureValue" value="${temperature.value}"/> ${temperatureValueErr}</div>
	<div>TIME: <input type="text" name="temperatureEvaluationTime" value="${temperature.evaluationTime}"/> ${temperatureEvaluationTimeErr}</div>
	<div><input type="submit" name="sumbit" value="invia" /></div>
	</form>
</body>
</html> 