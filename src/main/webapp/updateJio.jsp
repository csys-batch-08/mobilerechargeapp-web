<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>UpdateJioNet</title>

<link rel="stylesheet" type="text/css" href="assets/css/update.css">
</head>
<body style="text-align: center;">

	<div class="header">
		<a href="adminHome.jsp">ADMIN</a> <a href="addJio.jsp"> JIO </a> <a
			href="addAirtel.jsp">AIRTEL</a> <a href="addVodafone.jsp">VODAFONE</a>
		<a href="addBsnl.jsp">BSNL</a> <a href="index.jsp">LOGOUT</a>

	</div>
	<form action="UpdatejioController " method="get">
		<h1>UPDATE JIOPLAN</h1>
		<div>
			<label for="planName"><strong>PlanName:</strong></label> <input
				type="text" name="planname" id="planName">
		</div>
		<br>
		<br>
		<div>
			<label for="Price"><strong>PlanAmount:</strong></label> <input
				type="text" name="price" id="Price" pattern="[0-9]+"
				title="invalid price,Amount should be in Positive value">
		</div>
		<br>
		<br>
		<div>
			<label for="Validity"><strong>Validity:</strong></label> <input
				type="text" name="validity" id="Validity">
		</div>
		<br>
		<br>
		<div>
			<label for="Benefits"><strong>Benefits:</strong></label> <input
				type="text" name="benefits" id="Benefits">
		</div>
		<br>
		<br>
		<div>
			<label for="jioplanid"><strong>planId:</strong></label> <input
				type="number" name="jioplanId" id="jioplanid">
		</div>
		<br>
		<br>
		<button>UPDATE</button>
		<c:if test="${jioplanId!=null }">
			<h3>${jioplanId}</h3>
			<c:remove var="jioplanId" scope="session" />
		</c:if>

	</form>
</body>
</html>