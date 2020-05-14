<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Celeb Detail</title>
</head>
<body>
	<%
		out.println(session.getAttribute("celebDetail"));
	%>
</body>
</html>