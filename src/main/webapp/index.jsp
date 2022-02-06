<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
<link rel="stylesheet" type="text/css" href="assets/css/index.css"> 
<link rel="stylesheet" type="text/css" href="sweetalert.css">
</head>
<body>
<div>
<h1 >Mobile Recharge App</h1>

 
 
	<Form action="AdminController">
		<h1 style="font-style: italic;">Login</h1>


		<label for="Email">EmailId</label>
		 <input type="email" name="email"
			id="Email" title="must follow the email format" autofocus required
			pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> <span></span>


		<label for="PASSWORD">Password</label> 
		<input type="password"
			name="password" id="PASSWORD" pattern="[a-zA-Z0-9&@#$_]{8,15}"
			title="8
				 or more character may include (&@#$_)" required>
         <c:if test="${invalid!=null }">
        <h3>${invalid}</h3>
        <c:remove var="invalid" scope="session" />
        </c:if> 

       <button onclick="validiateUser;">LOGIN</button>
       <a href="forgetPassword.jsp">ForgetPassword?</a>
       <a href="register.jsp">SignUp?</a> 
       <script src="sweetalert.min.js"></script>
       
       <script type="text/javascript">
       function validiateUser()
       {
    	   var emailId="mani99@gmail.com";
    	   var passwords="143@mani";
    	   var EmailId=doucument.getElementById('emailId').value;
    	   var Password=doucument.getElementById('passwords').value;
    	   if((EmailId==emailId)&&(Password==passwords)){
    		   swal("Good job!", "You clicked the button!", "success");
    	   }
    	   else{
    		   swal("Good job!", "email id wrong ", "error");

    	   }
       }
       </script>
      
	</Form>
</div>
</body>
</html>