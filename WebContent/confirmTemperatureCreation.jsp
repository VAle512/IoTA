<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creation successful</title>
</head>
<body>
<h1>You have successfully inserted the following temperature:</h1>
<div>ID: ${temperature.id}</div>
<div>Value: ${temperature.value }</div>
<div>Evaluation time: ${temperature.evaluationTime}</div>
<div>Source board id: ${arduinoBoard.id}</div>
</body>
</html>