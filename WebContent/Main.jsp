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
<link rel="stylesheet" href="Main.css" >
</head>
<body id="body">
	<div id="div1">
	<form  action="ApplicantLogout">
		<input id="logout" type="submit" value="Logout">
	</form>
	</div>
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
	<a class="a" href="http://localhost:8080/appointment/ApplicantDetail.jsp"><button id="user" >User</button></a>
	</div>
	<br>
	<br>
	<div align="center">
		<%
		}
			if(applicantID!=null && verifiedCelebs!=null){
				%>
				<label id="search">Search celebs: </label><input type="text" onkeyup="searchCeleb(this.value)"><br>
				<div id="suggestedCeleb">
				</div>
				<br>
				<br><br>
				<% 
				int n=verifiedCelebs.size();
				out.println("<b id='celebAvailable'>Celebs Available</b><br>");
				%>
				<table>
				<% 
				for(int i=0;i<n;i++){
					int celebId=verifiedCelebs.get(i);
					Celebrity celeb=serv.getCelebrity(celebId);
					String name=celeb.getName();
					%>
						<tr>
							<th><a class="a" href="showCelebGet?celebId=<% out.print(celeb.getCelebId()); %>">
							<b id="name" ><%= name %>:</b></a></th>
							<th><a class="a" href="applyForm.jsp?celebId=<% out.print(celeb.getCelebId()); %>">
							<button id="apply" >Apply</button>
							</a></th>
						</tr>
					<% 
			
				}
				%>
				</table>
				<% 
			}
		%>
	</div>
</body>
	<script src="celebSuggestion.js">
	</script>
</html>