<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ForgetPasswordController" method="get">
<label for="Email">EmailId</label>
		 <input type="email" name="email"
			id="Email" title="must follow the email format" autofocus required
			pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> 
			
		<label for="PASSWORD">Password</label> 
		<input type="password"
			name="password" id="PASSWORD" pattern="[a-zA-Z0-9&@#$_]{8,15}"
			title="8
				 or more character may include (&@#$_)" required>
			<input type="submit" value="password">
</form>
</body>
</html>