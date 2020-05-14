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
</head>
<body align="center">
	<form action="ApplicantLogout">
		<input type="submit" value="Logout">
	</form>
	<button><a href="http://localhost:8080/appointment/Main.jsp">Back</a></button>
	<%
		try{
			int applicantId=-1;
			Integer applicantID=(Integer)session.getAttribute("applicantId");
			if(applicantID==null)
				response.sendRedirect("http://localhost:8080/appointment/");
			else
				applicantId=applicantID;
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
			out.println("<h2>"+"My Applications:"+"</h2>");
			ArrayList<Integer> applications=serv.getApplicationList(applicantId);
			if(applications!=null){
				for(int i=0;i<applications.size();i++){
					int celebId=serv.getCelebIdFromApplication(applications.get(i));
					String celebName=serv.getCelebrity(celebId).getName();
					String status=serv.getStatusApplication(applications.get(i));
					int applicationId=applications.get(i);
					out.println("<b>"+celebName+": </b>"+status);
					//System.out.println(serv.getApplicationMessagingStatus(applicationId));
					if(serv.getApplicationMessagingStatus(applicationId)==1){
						%>
						<a href="ChatForApplicant.jsp?applicationId=<% out.print(applicationId);%>">
							<button>Go to Chat</button></a>
						<% 
					}
					out.println("<br><br>");
				}
			}
			else
				out.println("No Applications yet");
		}
		catch(Exception e){
			out.println("Error Occured");
		}
		
	%>

</body>
</html>