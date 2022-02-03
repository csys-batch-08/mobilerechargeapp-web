<%@page import="com.mobilerechargeapp.exception.ErrorFound"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@page import="java.util.Date"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.*"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>RechargeyourNumber</title>
<link rel="stylesheet" type="text/css" href="assets/css/recharge.css"> 

</head>
<body>



	<div class="header">
		<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
			href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
		<a href="contectus.jsp">ContectUs</a> <a href="logout.jsp">Logout</a>
	</div>
	<form action="RechargeController">
		<h1>RECHARGE YOUR NUMBER</h1>
		<label for="MobileNumber"><strong>MOBILE NUMBER</strong></label> <input
			type="text" name="mobileNumber" id="MobileNumber"
			pattern="[7-9]{1}[0-9]{9}"
			title="Phone number with 7-9 and remaing 9 digit with 0-9" required><br>		
		<div class="formBtn">

			<input type="submit" value="Recharge">
		</div>
	</form>
</body>
</html>



	