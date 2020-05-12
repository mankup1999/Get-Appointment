<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Celeb Sign Up</title>
</head>
<body>
	<form method="post" action="InsertCeleb">
	Name : <input type="text" name="name" required><br/>
	Email : <input type="text" name="email" required><br/>
	Mob : <input type="text" name="mob" required><br/>
	Username : <input type="text" name="username" required><br/>
	Password : <input type="text" name="password" required><br/>
	Confirm Password : <input type="password" name="conf_password" required><br/>
	Office Address : <input type="text" name="officeAddress" required><br/>
	<input type="submit" name="Sign Up"><br/>
	</form>
</body>
</html>