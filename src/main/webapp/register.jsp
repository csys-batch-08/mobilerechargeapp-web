<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>

<link rel="stylesheet" type="text/css" href="assets/css/register.css"> 

</head>
<body>

<c:if test="${email!=null }">
<h2>${email}</h2>
  <c:remove var="email" scope="session" />
        </c:if> 
	<form action="UserController" style="text-align: center" method="post">

		<h1 style="font-style: italic;">Register Login</h1>


		<label for="Username">UserName:</label> 
		<input type="text" name="username" id="Username"> 
		<label for="Email">Email-id:</label>
		<input type="email" name="email" id="Email"
			title="must follow the email format" autofocus required
			pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> <label
			for="Mobilenumber">MobileNumber:</label> <input type="text"
			name="phonenumber" id="Mobilenumber" pattern="[6-9]{1}[0-9]{9}"
			title="Phone number with 7-9 and remaing 9 digit with 0-9" required><br>
		<label for="PASSWORD">Password:</label> <input type="password"
			name="password" id="Password" pattern="[a-zA-Z0-9&@#$_]{8,15}"
			title="8
				 or more character may include (&@#$_)" required><br>
		<label for="Operatorname">OperatorName</label> <input type="text"
			name="operatorName" id="Operatorname" required><br> 
			
			<div class="formBtn">
			
			 <input type="submit"
			value="SignIn">
			</div>


	</form>

</body>
</html>