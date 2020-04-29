<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant Sign Up</title>
</head>
<body>
	<form method="post" action="InsertApplicant">
	Name : <input type="text" name="name"><br/>
	Email : <input type="text" name="email"><br/>
	Mob : <input type="text" name="mob"><br/>
	Username : <input type="text" name="username"><br/>
	Password : <input type="text" name="password"><br/>
	Confirm Password : <input type="password" name="conf_password"><br/>
	<input type="submit" name="Sign Up"><br/>
	</form>

</body>
</html>