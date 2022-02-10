<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ForgetPassword</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/forgetPassword.css">
</head>
<body>
	<div>
		<div>
			<form action="ForgetPassword" method="post">
				<h1 style="text-align: center;">Forgot Password</h1>
				<input type="email" name="email" aria-label="email"
					title="must follow the email format" autofocus required
					pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> <span></span>
				<input type="password" name="PASSWORD" aria-label="PASSWORD"
					required placeholder="Enter the Password"
					pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
					title=" mininum 8characters may includes @#$%&*_?/ " /><br /> <br />
				<input type="password" name="CONFIRM" aria-label="CONFIRM" required
					placeholder="Enter the Confirm Password"
					pattern="[0-9A-Za-Z@#$%&*_?/]{8,15}"
					title=" mininum 8characters may includes @#$%&*_?/ " /><br /> <br />
				<button>Sumbit</button>
				<button class="reset">reset</button>
				<c:if test="${requestScope.PasswordError!=null }">
					<p class="text-primary">${PasswordError}</p>
				</c:if>
				<c:if test="${requestScope.mailError!=null }">
					<p class="text-primary">${mailError}</p>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>