<%@page import="co.manku.main.Celebrity"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply Form</title>
<link rel="stylesheet" href="applyForm.css">
</head>
<body id="body">
<div id="div2">
	<button class="input1"><a style="text-decoration:none;color:green;" href="http://localhost:8080/appointment/Main.jsp">Back</a></button>
	</div>
	<div id="div1" align="right">
	<form action="ApplicantLogout">
		<input class="input1" type="submit" value="Logout">
	</form>
	</div>
	<div id="div3">
	<%
		int celebId=-1;
		if(request.getParameter("celebId")==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		else
			celebId=Integer.parseInt(request.getParameter("celebId"));
		session.setAttribute("celebId", celebId);
		Service serv=new Service();
		Celebrity celeb=serv.getCelebrity(celebId);
		out.println("<b id='title'>"+celeb.getName()+"</b><br>");
		out.println("<b id='addr'>"+celeb.getOfficeAddress()+"</b><br><br><br>");
	%>
	<div style="margin-left:30px;">
	<form action="applyAppointment" method="post">
		<span id="span1">Why do you want appointment?(100-300 words)</span><br>
		<textarea id="tx1" rows="5" cols="100" name="intent" required></textarea><br>
		<input id="apply" type="submit" value="apply">
	</form>
	</div>
	</div>
</body>
</html>