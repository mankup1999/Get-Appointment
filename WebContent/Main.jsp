<%@page import="java.util.ArrayList"%>
<%@page import="co.manku.main.Celebrity"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Appointment</title>
</head>
<body>
	<form action="ApplicantLogout">
		<input type="submit" value="Logout">
	</form>
	<%
		int applicantId=-1;
		Integer applicantID=(Integer)session.getAttribute("applicantId");
		if(applicantID!=null)
			applicantId=applicantID;
		Service serv=new Service();
		ArrayList<Integer> verifiedCelebs=serv.getVerifiedCelebs();
		if(applicantID==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		if(applicantID!=null){
	%>
	<div align="right">
		<a href="http://localhost:8080/appointment/ApplicantDetail.jsp"><h2>User</h2></a>
	</div>
	<div align="center">
		<%
		}
			if(applicantID!=null && verifiedCelebs!=null){
				int n=verifiedCelebs.size();
				out.println("<h1>Celebs Available</h1>");
				for(int i=0;i<n;i++){
					int celebId=verifiedCelebs.get(i);
					Celebrity celeb=serv.getCelebrity(celebId);
					String name=celeb.getName();
					%>
							<a href="showCelebGet?celebId=<% out.print(celeb.getCelebId()); %>">
							<b><%= name %>:</b></a>
							<a href="applyForm.jsp?celebId=<% out.print(celeb.getCelebId()); %>">
							<b>Apply</b>
							</a>
							<br>
							<br>
					<% 
			
				}
			}
		%>
	</div>
</body>
</html>