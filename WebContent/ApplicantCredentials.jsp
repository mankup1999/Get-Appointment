<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant Login</title>
</head>
<body>
	<button><a href="http://localhost:8080/appointment/">Main Page</a></button>
	<form method="post" action="validApplicant">
	Username:<input type="text" name="username" required><br>
	Password:<input type="password" name="password" required><br>
	ReCaptcha:
	<label><span id="num1"></span>+<span id="num2"></span></label>=<input type=text id="result" onkeyup="checkResult(this.value)" required>
	<br>
	<input type="submit" value="Login" id="submit_id">
	</form>
	New user?<a href="http://localhost:8080/appointment/SignUpApplicant.jsp">Register here</a>
</body>
<script>
		var num1=Math.floor(Math.random()*100+1);
		document.getElementById("num1").innerHTML=num1;
		var num2=Math.floor(Math.random()*100+1);
		document.getElementById("num2").innerHTML=num2;
		function checkResult(str){
			if(str.length==0){
				return;
			}
			else{
				var result=Number(str);
				if(result!=(num1+num2))
					document.getElementById("submit_id").disabled=true;
				else
					document.getElementById("submit_id").disabled=false;
					
			}
		}
	</script>
</html>