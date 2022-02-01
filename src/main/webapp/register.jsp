<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>
<style>
* {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
/* 	cursor: pointer; */
}
body {
	height: 100vh;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(to right, #3f56fb, #fc466b);
}
form {
    width: 27rem;
    padding: 29px 16px;
    flex-direction: column;
    background: rgba(255, 255, 255, 0.06);
    box-shadow: 0 8px 32px 0 rgb(31 38 135 / 37%);
    border-radius: 30px;
    border-left: 1px solid;
    border-left: 1px solid rgba(255, 255, 255, .3);
    border-left: 1px solid rgba(255, 255, 255, .3);
}
h1 {
    text-align: center;
    font-size: 21px;
    color: white;
    text-shadow: 2px 2px 4px rgb(0 0 0 / 20%);
    letter-spacing: 3px;
    margin-bottom: 2%;
    opacity: .7;
    margin-top: 10px;
}
label {
    font-size: 15px;
    color: white;
    opacity: .8;
    text-shadow: 2px 2px 4px rgb(0 0 0 / 20%);
    text-align: left;
    margin-top: 11px;
    display: block;
}
input {
    font-size: 20px;
    width: 100%;
    margin: 0px auto;
    border: none;
    outline: none;
    background: #00000030;
    color: white;
    border-bottom: 1px solid rgba(255, 255, 255, 0.6);
    margin-top: 10px;
    padding: 2px 15px;
}
.formBtn input {
    border: 1px solid;
    display: block;
    background: none;
    width: auto;
    padding: 6px 26px;
    border-radius: 3px;
    font-size: 16px;
    margin-top: 17px;
}
</style>

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