<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Details</title>
</head>
<body align="center">
	<h1>Celeb Details:</h1>
	<%
		String detail=session.getAttribute("celebDetail").toString();
		out.println(detail);
	%>

</body>
</html>