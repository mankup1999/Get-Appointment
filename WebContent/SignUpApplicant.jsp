<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant Sign Up</title>
<link rel="stylesheet" href="SignUpApplicant.css">
</head>
	<script src="ValidateApplicantDetails.js">
	</script>
<body id="body">
	<label id="title">Aplicant Registration</label>
	<br><br>
	<form method="post" action="InsertApplicant">
	<table>
	<tr><th class="th1">Name : </th><th><input class="th2" type="text" name="name" onkeyup="myName(this.value)" required></th><th><span id="name" class="th3" ></span></th></tr>
	<tr><th class="th1">Email : </th><th><input class="th2" type="text"  name="email" onkeyup="myEmail(this.value)" required></th><th><span id="email" class="th3"></span></th></tr>
	<tr><th class="th1">Mob : </th><th><input class="th2" type="text"  name="mob" onkeyup="myMob(this.value)" required></th><th><span id="mob" class="th3"></span></th></tr>
	<tr><th class="th1">Username : </th><th><input class="th2" type="text"  name="username" onkeyup="myUsername(this.value)" required></th><th><span id="username" class="th3"></span></th></tr>
	<tr><th class="th1">Password : </th><th><input class="th2" type="text"  id="conf" name="password" onkeyup="myPassword(this.value)" required></th><th><span id="password" class="th3"></span></th></tr>
	<tr><th class="th1">Conf Pass. : </th><th><input class="th2" type="password"  onkeyup="myConfPassword(this.value)" name="conf_password" required></th><th><span id="conf_password" class="th3"></span></th></tr>
	<tr><th colspan="2"><input  type="submit" name="Sign Up" id="submit_id"></th></tr>
	</table>
	</form>
</body>
</html>