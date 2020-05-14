<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Sign Up</title>
</head>
	<script src="ValidateCelebDetails.js">
	</script>
<body>
	<form method="post" action="InsertCeleb">
	Name : <input type="text" onkeyup="myName(this.value);" name="name" required><span id="name" ></span><br/>
	Email : <input type="text" onkeyup="myEmail(this.value)" name="email" required><span id="email"></span><br/>
	Mob : <input type="text" onkeyup="myMob(this.value)" name="mob" required><span id="mob"></span><br/>
	Username : <input type="text" onkeyup="myUsername(this.value)" name="username" required><span id="username"></span><br/>
	Password : <input type="text" id="conf" onkeyup="myPassword(this.value)" name="password" required><span id="password"></span><br/>
	Confirm Password : <input type="password"  onkeyup="myConfPassword(this.value)" name="conf_password" required><span id="conf_password"></span><br/>
	Office Address : <input type="text" name="officeAddress" required><br/>
	<input type="submit" name="Sign Up" id="submit_id"><br/>
	</form>
</body>
</html>