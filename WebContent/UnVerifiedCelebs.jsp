<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UnVerified Celebs</title>
</head>
<body>
	<h1>List of Celebs to Verify :</h1>
	<%
	ArrayList<Integer> celebs=(ArrayList<Integer>)session.getAttribute("celebs");
	if(celebs==null)
		out.println("All celebs verified");
	else{
		int n=celebs.size();
		for(int i=0;i<n;i++){
			String celebId=new String(celebs.get(i).toString());
			%>
			<form method="post" action="doVerify">
				<% out.print(celebId+" : "); %>
				<input type="submit" value="verify" name=<%= celebId %> >
			</form>
			<form method="post" action="showCeleb">
				<input type="submit" value="show" name=<%=celebId %>><br/>
			</form>
			<% 
		}
	}
	%>
</body>
</html>