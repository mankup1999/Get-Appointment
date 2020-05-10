<%@page import="java.util.ArrayList"%>
<%@page import="co.manku.service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Details</title>
</head>
<body align="center">
	<h1>Celeb Details:</h1>
	<%
		String detail=session.getAttribute("celebDetail").toString();
		detail=detail.substring(detail.indexOf("[")+1,detail.lastIndexOf("]"));
		String[] details=detail.split(", ");
		for(String x:details){
			String[] y=x.split("=");
			switch(y[0]){
				case "name":out.println("<b>Name: </b>"+y[1]+"<br>");break;
				case "email":out.println("<b>Email: </b>"+y[1]+"<br>");break;
				case "mob":out.println("<b>Phone: </b>"+y[1]+"<br>");break;
				case "officeAddress":out.println("<b>Office Addr: </b>"+y[1]+"<br>");break;
			}
		}
		
		
	%>

</body>
</html>