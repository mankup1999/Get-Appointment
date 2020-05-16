<%@page import="java.util.ArrayList"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Details</title>
<link rel="stylesheet" href="celebDetailsForOther.css">
</head>
<body id="body">
	<form action="CelebLogout">
		<input id="logout" type="submit" value="Logout">
	</form>
	<div id="div1">
	<b id="title">Your Details:</b><br><br>
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
				switch(y[0]){
					case "name":out.println("<b class='b1'>Name: </b><span class='span1'>"+y[1]+"</span><br>");break;
					case "email":out.println("<b class='b1'>Email: </b><span class='span1'>"+y[1]+"</span><br>");break;
					case "mob":out.println("<b class='b1'> Phone: </b><span class='span1'>"+y[1]+"</span><br>");break;
					case "officeAddress":out.println("<b class='b1'>Office Addr: </b><span class='span1'>"+y[1]+"</span><br>");break;
				}
			}
			%>
			</div>
			<div id="div2">
			<% 
			int celebId=Integer.parseInt(detail.substring(detail.indexOf("celebId")+8,detail.indexOf(",")));
			//out.println(celebId);
			Service serv=new Service();
			ArrayList<Integer> applications=serv.getApplicationListforCeleb(celebId);
			//System.out.println(applications);
			
			if(applications!=null){
				out.println("<br><br><b id='list'>Applications list:</b><br><br>");
				for(int i=0;i<applications.size();i++){
					int applicationId=applications.get(i);
					String intent=serv.getIntent(applicationId);
					int applicantId=serv.getApplicantId(applicationId);
					String applicantName=serv.getApplicant(applicantId).getName();
					//out.println(i+1+". ");
					//out.println("<a href='http://localhost:8080/appointment/ApplicantDetailForOthers.jsp'>"+applicantName+": </a>");
					%>
						<a id="anch1" href="ApplicantDetailForOthers.jsp?applicantId=<% out.print(applicantId);%>">
							<%=(i+1)+". "+applicantName  %></a>
					<% 
					out.println("<span id='span2'>"+"\""+intent+"\"</span>");
					String status=serv.getStatusApplication(applicationId);
					out.println("<b id='status'>"+status+"</b>");
					
					if(!status.equalsIgnoreCase("Approved")){
						%>
						<a  href="approveApplication?applicationId=<% out.print(applicationId);%>">
							<button class="anch2">Approve</button></a>
						<% 
					}
	
					int isEnabledMsg=serv.getApplicationMessagingStatus(applicationId);
					if(status.equalsIgnoreCase("Approved") && isEnabledMsg==0){
						%>
						<a href="enableMessaging?applicationId=<% out.print(applicationId);%>">
							<button class="anch2">Enable Chat</button></a>
						<%	
					}
					if(isEnabledMsg==1){
						%>
						<a href="ChatForCeleb.jsp?applicationId=<% out.print(applicationId);%>">
							<button class="anch2">Go to Chat With Client</button></a>
						<%
					}
					out.println("<br>");
				}
			}
			else
				out.println("<br><b>No Applications</b>");
			%>
			</div>
			<% 
			
		}
		
	%>

</body>
</html>