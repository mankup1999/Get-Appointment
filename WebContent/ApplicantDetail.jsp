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
<link rel="stylesheet" href="ApplicantDetail.css">
</head>
<body id="body">
	<div id="div1">
	<form action="ApplicantLogout">
		<input class="input1" type="submit" value="Logout">
	</form>
	</div>
	<div id="div2"><button class="input1"><a style="text-decoration:none;color:red;opacity:.7;" href="http://localhost:8080/appointment/Main.jsp">Back</a></button></div>
	<br><br>
	<br><br><br>
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
				out.println("<br><b id='title'>Applicant Details</b><br><br><br><br>");
					%>
					<div id="div3">
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
					</div>
					 
					<div id="div4">
					
			<b style='font-size:25px;margin-left:80px;color:brown;opacity:.5;'>My Applications</b><br><br>
					<% 
			ArrayList<Integer> applications=serv.getApplicationList(applicantId);
			if(applications!=null){
				for(int i=0;i<applications.size();i++){
					int celebId=serv.getCelebIdFromApplication(applications.get(i));
					String celebName=serv.getCelebrity(celebId).getName();
					String status=serv.getStatusApplication(applications.get(i));
					int applicationId=applications.get(i);
					out.println("<b id='name'>"+celebName+": </b><span style='color:red;font-size:20px;'>"+status+"</span>");
					//System.out.println(serv.getApplicationMessagingStatus(applicationId));
					if(serv.getApplicationMessagingStatus(applicationId)==1){
						%>
						<a href="ChatForApplicant.jsp?applicationId=<% out.print(applicationId);%>">
							<button id="an">Go to Chat</button></a>
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
	</div>

</body>
</html>