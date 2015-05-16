<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserimento Temperatura</title>
</head>
<body>
	<h1>Inserimento nuova Temperatura</h1>
	<form action="controller/arduinoBoard.create" method="get">
		<div>
			Code: <input type="text" name="arduinoBoardCode"
				value="${adrduinoBoard.code}" /> <font color="red">${arduinoCodeErr}
			</font>
		</div>
		<div>
			<input type="submit" name="sumbit" value="invia" />

		</div>
	</form>
</body>
</html>