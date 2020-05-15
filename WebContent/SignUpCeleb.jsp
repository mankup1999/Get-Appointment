<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Sign Up</title>
<link rel="stylesheet" href="SignUpApplicant.css">
</head>
	<script src="ValidateCelebDetails.js">
	</script>
<body id="body">
	<label id="title">Celeb Registration</label>
	<br><br>
	<form method="post" action="InsertCeleb">
	<table>
	<tr><th class="th1">Name : </th><th><input  class="th2" type="text" onkeyup="myName(this.value);" name="name" required></th><th><span id="name" class="th3" ></span></th></tr>
	<tr><th class="th1">Email : </th><th> <input class="th2"  type="text" onkeyup="myEmail(this.value)" name="email" required></th><th><span id="email" class="th3"></span></th></tr>
	<tr><th class="th1">Mob : </th><th><input class="th2"  type="text" onkeyup="myMob(this.value)" name="mob" required></th><th><span id="mob" class="th3"></span></th></tr>
	<tr><th class="th1">Username : </th><th><input class="th2"  type="text" onkeyup="myUsername(this.value)" name="username" required></th><th><span id="username" class="th3"></span></th></tr>
	<tr><th class="th1">Password : </th><th><input class="th2"  type="text" id="conf" onkeyup="myPassword(this.value)" name="password" required></th><th><span id="password" class="th3"></span></th></tr>
	<tr><th class="th1">Conf Pass : </th><th><input class="th2"  type="password"  onkeyup="myConfPassword(this.value)" name="conf_password" required></th><th><span id="conf_password" class="th3"></span></th></tr>
	<tr><th class="th1">Office : </th><th><input class="th2" type="text" name="officeAddress" required></th></tr>
	<tr><th colspan="2"><input type="submit" name="Sign Up" id="submit_id">
	</form>
</body>
</html>