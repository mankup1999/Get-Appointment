<%@page import="co.manku.service.Service"%>
<%@page import="co.manku.main.Applicant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant Detail</title>
</head>
<body align="center">
	<%
		try{
			int applicantId=(Integer)session.getAttribute("applicantId");
			Service serv=new Service();
			Applicant applicant=serv.getApplicant(applicantId);
			if(applicant!=null)
				out.println("<h1>Applicant Details</h1>");
					%>
					<table align="center">
						<tr>
						<th>Name: </th>
						<td><%= applicant.getName() %></td>
						</tr>
						<tr>
						<th>Email: </th>
						<td><%= applicant.getEmail() %></td>
						</tr>
						<tr>
						<th>Mob: </th>
						<td><%= applicant.getMob() %></td>
						</tr>
						<tr>
						<th>Address: </th>
						<td><%= applicant.getAddress() %></td>
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