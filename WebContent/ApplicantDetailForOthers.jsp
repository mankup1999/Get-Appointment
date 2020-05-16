<%@page import="java.util.ArrayList"%>
<%@page import="co.manku.service.Service"%>
<%@page import="co.manku.main.Applicant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant Detail</title>
<link rel="stylesheet" href="ApplicantDetailForOthers.css">
</head>
<body id="body">
	<div id=div1>
	<form action="CelebLogout">
		<input  class="anch1" type="submit" value="Logout">
	</form>
	</div>
	<div id="div2">
	<form action="CelebBack">
		<input class="anch1" type="submit" value="Back">
	</form>
	</div>
	<%
		try{
			int applicantId=-1;
			String applicantID=(String)request.getParameter("applicantId");
			if(applicantID==null || session.getAttribute("celebDetail")==null)
				response.sendRedirect("http://localhost:8080/appointment/");
			else
				applicantId=Integer.parseInt(applicantID);
			Service serv=new Service();
			Applicant applicant=serv.getApplicant(applicantId);
			%>
			<% 
			if(applicant!=null)
				out.println("<br><br><br><b id='title'>Applicant Details</b><br><br>");
					%>
					<table align="center">
						<tr>
						<th class="th1">Name: </th>
						<td class="th2"><%= applicant.getName() %></td>
						</tr>
						<tr>
						<th class="th1">Email: </th>
						<td class="th2"><%= applicant.getEmail() %></td>
						</tr>
						<tr>
						<th class="th1">Mob: </th>
						<td class="th2"><%= applicant.getMob() %></td>
						</tr>
						<tr>
						<th class="th1">Address: </th>
						<td class="th2"><%= applicant.getAddress() %></td>
						</tr>
					</table>
					
					<%
		}
		catch(Exception e){
			out.println("Error Occured");
		}
		
	%>

</body>
</html>