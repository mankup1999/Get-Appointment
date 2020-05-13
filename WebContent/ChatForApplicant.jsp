<%@page import="co.manku.main.Celebrity"%>
<%@page import="co.manku.main.Applicant"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat For Applicant</title>
</head>
<body>
	<form action="ApplicantLogout">
		<input type="submit" value="Logout">
	</form>
	<form action="ApplicantBack">
		<input type="submit" value="Back">
	</form>
	<%
		//System.out.println(session.getAttribute("applicantId"));
		//System.out.println(request.getParameter("applicationId"));
		if(session.getAttribute("applicantId")==null || request.getParameter("applicationId")==null)
			response.sendRedirect("http://localhost:8080/appointment/");
		else{
			int applicationId=Integer.parseInt(request.getParameter("applicationId"));
			Service serv=new Service();
			int celebId=serv.getCelebIdFromApplication(applicationId);
			Celebrity celeb=serv.getCelebrity(celebId);
			out.println(celeb.toString()+"<br><br>");
			ArrayList<HashMap<String,String>> chats=serv.fetchChats(applicationId);
			System.out.println(chats);
			if(chats!=null){
				for(int i=0;i<chats.size();i++){
					HashMap<String,String> map=chats.get(i);
					String type="celeb";
					if(!map.containsKey(type))
						type="applicant";
					String msg=(String)map.get(type);
					
					out.println("<b>"+type+":</b>"+msg+"<br>");
				}
			}
		
			%>
			<form action="sendToCeleb" method="post">
				You:<input type="text" name="data" required>
				<input type="hidden" name="applicationId" value="<%= applicationId %>">
				<input type="submit" value="send">
			</form>
			<% 
			
		}
	%>
</body>
</html>