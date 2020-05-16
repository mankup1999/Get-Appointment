<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celebrity Login</title>
<link rel="stylesheet" href="CelebCredentials.css">
</head>

<body id="body" style="margin-left:450px;margin-top:200px;">
	<label id="title">Celeb Login</label><br>
	<button><a class="a" href="http://localhost:8080/appointment/">Main Page</a></button>
	<br>
	<br>
	<form method="post" action="validCeleb">
	<table>
	<tr><th class="th1">Username:</th><th ><input class="th2" type="text" name="username" onkeyup="myUsername(this.value)" required></th><th id="username"></th></tr>
	<tr><th class="th1">Password:</th><th ><input class="th2" type="password" name="password" onkeyup="myPassword(this.value)"  required></th><th id="password" ></th></tr>
	<tr><th class="th1">  solve:
	<label><span id="num1"></span>+<span id="num2"></span></label>=</th><th><input class="th2" type=text id="result" onkeyup="checkResult(this.value)" required>
	</th></tr>
	<tr><th colspan="2"><input type="submit" value="Login" id="submit_id"></th></tr>
	</table>
	</form><br>
	<label id="new">New user?</label><a class="a" href="http://localhost:8080/appointment/SignUpCeleb.jsp">Register here</a>
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
		function myUsername(str){
			if(str.length==0){
				document.getElementById("username").innerHTML="";
				return;
			}
			else{
				var xmlhttp=new XMLHttpRequest();
				xmlhttp.onreadystatechange=function(){
					if(this.readyState==4 && this.status==200){
						document.getElementById("username").innerHTML=this.responseText;
						checkResult(str);
					}
				};
				
				xmlhttp.open("GET","http://localhost:8080/appointment/usernameValidate?username="+str,true);
				xmlhttp.send();
				
			}
		}
		function myPassword(str){
			if(str.length==0){
				document.getElementById("password").innerHTML="";
				return;
			}
			else{
				    var xmlhttp=new XMLHttpRequest();
				    xmlhttp.onreadystatechange=function(){
					if(this.readyState==4 && this.status==200){
						document.getElementById("password").innerHTML=this.responseText;
						checkResult(str);
					}
				};
				
				xmlhttp.open("GET","http://localhost:8080/appointment/passwordValidate?password="+str,true);
				xmlhttp.send();
			}
		}
	</script>
</html>