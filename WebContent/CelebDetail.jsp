<%@page import="java.util.ArrayList"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Details</title>
<link rel="stylesheet" href="CelebDetail.css" >
</head>
<body id="body">
	<div id=div1>
	<form action="ApplicantLogout">
		<input class="anch1" type="submit" value="Logout">
	</form>
	</div>
	<div id="div2">
	<button class="anch1"><a style="text-decoration:none;" href="http://localhost:8080/appointment/Main.jsp">Back</a></button>
	</div>
	<br><br><br>
	<b id="title">Celeb Details:</b><br><br>

	<%
	    Object abc=session.getAttribute("celebDetail");
		//System.out.println(abc);
		if(abc==null)
				response.sendRedirect("http://localhost:8080/appointment/");
		else{
			String detail=session.getAttribute("celebDetail").toString();
			detail=detail.substring(detail.indexOf("[")+1,detail.lastIndexOf("]"));
			String[] details=detail.split(", ");
			for(String x:details){
				String[] y=x.split("=");
				%>
				<table align="center">
				<% 
				switch(y[0]){
					case "name":out.println("<tr><th><b class='th1'>Name: </b></th><td><span class='th2'>"+y[1]+"</span></td></tr>");break;
					case "email":out.println("<tr><th><b class='th1'>Email: </b></th><td><span class='th2'>"+y[1]+"</span></td></tr>");break;
					case "mob":out.println("<tr><th><b class='th1'>Phone: </b></th><td><span class='th2'>"+y[1]+"</span></td></tr>");break;
					case "officeAddress":out.println("<tr><th><b class='th1'>Office Addr: </b></th><td><span class='th2'>"+y[1]+"</span></td></tr>");break;
				}
				%>
				</table>
				<% 
			}
			if(session.getAttribute("celebId")!=null){
				int celebId=(Integer)session.getAttribute("celebId");
				%>
					<br/>
					<div align="center">
					<button><a id="anch2" href="applyForm.jsp?celebId=<% out.print(celebId); %>">
					<b>Aply for Appointment</b>
					</a></button></div>
				<% 
			}
		}
		
		
	%>

</body>
</html>