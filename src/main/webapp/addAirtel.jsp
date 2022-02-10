<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>InsertAirtelPlan</title>
<link rel="stylesheet" type="text/css" href="assets/css/add.css">
</head>
<body style="text-align: center;">
	<div class="header">
		<a href="adminHome.jsp">ADMIN</a> <a href="addJio.jsp"> JIO </a> <a
			href="addAirtel.jsp">AIRTEL</a> <a href="addVodafone.jsp">VODAFONE</a>
		<a href="addBsnl.jsp">BSNL</a> <a href="index.jsp">LOGOUT</a>
	</div>
	<form action="AddairtelController">
		<h1 style="font-style: italic;">ADD PLAN</h1>
		<label for="PlanName"><strong>PlanName</strong></label> <input
			type="text" name="planname" aria-label="planname"><br> <br>
		<label for="Price"><strong>PlanAmount</strong></label> <input
			type="text" name="price" id="Price" pattern="[0-9]+"
			title="invalid price,Amount should be in Positive value"><br>
		<br> <label for="Validity"><strong>Validity</strong></label> <input
			type="text" name="validity" id="Validity"><br> <br>
		<label for="Benefits"><strong>Benefits</strong></label> <input
			type="text" name="benefits" id="Benefits"><br> <br>
		<label for="Operatorname"><strong>OperatorName</strong></label> <input
			type="text" name="operatorName" id="Operatorname" required><br>
		<br>
		<button>INSERT</button>
	</form>
</body>
</html>