<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
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
  form:before{
content:'';
position:absolute;
bottom:3%;
right:28px;
height:200px;
background:green;
border-radius:50%;
z-index:-1;
opacity:.8; 
}  

form {
    width: 25rem;
    /* height: 28rem; */
    padding: 45px 0px;
    display: flex;
    flex-direction: column;
    background: rgba(255, 255, 255, 0.06);
    box-shadow: 0 8px 32px 0 rgb(31 38 135 / 37%);
    border-radius: 30px;
    border-left: 1px solid;
    border-left: 1px solid rgba(255, 255, 255, .3);
}


h1 {
	text-align: center;
	font-size: 30px;
	color: white;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, .2);
	letter-spacing: 3px;
	margin-bottom: 5%;
 	opacity: .7; 
}

label {
	font-size: 20px;
	color: white;
	margin-left: 10%;
	opacity:.8;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, .2);
}

input {
    font-size: 20px;
    width: 80%;
    margin: 2% auto;
    margin-bottom: 3%;
    border: none;
    padding: 5px;
    outline: none;
    background: #0000003d;
    color: white;
    border-bottom: 1px solid rgba(255, 255, 255, 0.6);
}

button {
	width: 50%;
	margin: 3% auto;
	color:white;
	font-size:15px;
	opacity:.7;
	background:rgba(255,255,255,0.06);
	padding:10px 30px;
	border:none;
	outline:none;
	border-radiurs:20px;
	text-shadow:2px 2px 4px rgba(255,255,255,0.2);
	box-shadow:3px 3px 5px rgba(31,38,135,.37);
	border-left:1px solid rgba(255,255,255,.3);
	border-top:1px solid rgba(255,255,255,.3)
}
a{
  font-size:13px;
  text-align:center;
  color:white;
}


</style>
<!-- <link rel="stylesheet" href="style.css"> -->
</head>
<body>
<div>
<h1 >Mobile Recharge App</h1>

 
 <c:if test="${invalid!=null }">
        <h2>${invalid}</h2>
        <c:remove var="invalid" scope="session" />
        </c:if> 
	<Form action="AdminController" method="post">
		<h1 style="font-style: italic;">Login</h1>


		<label for="Email">Email-id</label>
		 <input type="email" name="email"
			id="Email" title="must follow the email format" autofocus required
			pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> <span></span>


		<label for="PASSWORD">Password</label> 
		<input type="password"
			name="password" id="PASSWORD" pattern="[a-zA-Z0-9&@#$_]{8,15}"
			title="8
				 or more character may include (&@#$_)" required>


       <button>LOGIN</button>
       <a href="register.jsp">SignUp?</a> 
<!--  <input type="sumbit" value="login"> -->
	</Form>
</div>
</body>
</html>