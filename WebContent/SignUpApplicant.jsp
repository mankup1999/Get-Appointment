<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant Sign Up</title>
</head>
	<script src="ValidateApplicantDetails.js">
	</script>
<body>
	<form method="post" action="InsertApplicant">
	Name : <input type="text" name="name" onkeyup="myName(this.value)" required><span id="name" ></span><br/>
	Email : <input type="text"  name="email" onkeyup="myEmail(this.value)" required><span id="email"></span><br/>
	Mob : <input type="text"  name="mob" onkeyup="myMob(this.value)" required><span id="mob"></span><br/>
	Username : <input type="text"  name="username" onkeyup="myUsername(this.value)" required><span id="username"></span><br/>
	Password : <input type="text"  id="conf" name="password" onkeyup="myPassword(this.value)" required><span id="password"></span><br/>
	Confirm Password : <input type="password"  onkeyup="myConfPassword(this.value)" name="conf_password" required><span id="conf_password"></span><br/>
	<input type="submit" name="Sign Up" id="submit_id"><br/>
	</form>
</body>
</html>