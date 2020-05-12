<%@page import="co.manku.main.Celebrity"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply Form</title>
</head>
<body>
	<%
		int celebId=-1;
		if(request.getParameter("celebId")==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		else
			celebId=Integer.parseInt(request.getParameter("celebId"));
		session.setAttribute("celebId", celebId);
		Service serv=new Service();
		Celebrity celeb=serv.getCelebrity(celebId);
		out.println("<h1>"+celeb.getName()+"<h1>");
		out.println("<h4>"+celeb.getOfficeAddress()+"<h4>");
	%>
	<form action="applyAppointment" method="post">
		Why do you want appointment?(100-300 words)<br>
		<textarea rows="10" cols="100" name="intent" required></textarea><br>
		<input type="submit" value="apply">
	</form>
</body>
</html>