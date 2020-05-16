<%@page import="co.manku.main.Applicant"%>
<%@page import="co.manku.service.Service"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat For Celeb</title>
<link rel="stylesheet" href="ChatForCeleb.css"> 
</head>
<body id="body">
	<div id="div1">
	<form action="CelebLogout">
		<input  class="input1" type="submit" value="Logout">
	</form>
	</div>
	<div id="div2">
	<form action="CelebBack">
		<input class="input1" type="submit" value="Back">
	</form>
	</div>
	<br><br><br>
	<div id="div3">
	<%
		//System.out.println(session.getAttribute("celebDetail"));
		//System.out.println(request.getParameter("applicationId"));
		if(session.getAttribute("celebDetail")==null || request.getParameter("applicationId")==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		else{
			int applicationId=Integer.parseInt(request.getParameter("applicationId"));
			Service serv=new Service();
			int applicantId=serv.getApplicantId(applicationId);
			Applicant applicant=serv.getApplicant(applicantId);
			%>
			<b class="title" align="center">Applicant Details:</b><br>
			<span class="span1">Name:</span><span class="span2"><%= applicant.getName() %></span><br>
			<span class="span1">Email:</span><span class="span2"><%= applicant.getEmail()%></span><br>
			<span class="span1">Mob:</span><span class="span2"><%= applicant.getMob() %></span><br>
			<span class="span1">Address:</span><span class="span2"><%= applicant.getAddress() %></span><br>
			</div>
			<div id="div4">
			<b class="title">Chats:</b><br><br>
			<% 
			ArrayList<HashMap<String,String>> chats=serv.fetchChats(applicationId);
			if(chats!=null){
				for(int i=0;i<chats.size();i++){
					HashMap<String,String> map=chats.get(i);
					String type="celeb";
					if(!map.containsKey(type))
						type="applicant";
					String msg=(String)map.get(type);
					if(type.equalsIgnoreCase("celeb"))
						out.println("<b id='b3'>You:"+msg+"</b><br>");
					else
						out.println("<b id='b4'>Applicant:"+msg+"</b><br>");
				}
			}
		
			%>
			<form action="sendToApplicant" method="post">
				You:<input type="text" name="data" required>
				<input type="hidden" name="applicationId" value="<%= applicationId %>">
				</a><input id="send" type="submit" value=">>>">
			</form>
			</div>
			<% 
			
		}
	%>
</body>
</html>