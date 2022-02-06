<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>bsnlShowPlan</title>
<link rel="stylesheet" type="text/css" href="assets/css/planAdmin.css"> 
</head>
<body>
<body style="text-align: center;">
	<div class="header">
		<a href="adminHome.jsp">ADMIN</a> <a href="addJio.jsp"> JIO </a> <a
			href="addAirtel.jsp">AIRTEL</a> <a href="addVodafone.jsp">VODAFONE</a>
		<a href="addBsnl.jsp">BSNL</a> <a href="index.jsp">LOGOUT</a>

	</div>




	<h1>
		<strong>BSNL NETWORK</strong>
	</h1>


	<table style="width: 100%">
		<tr>

			<td><strong>PLANID</strong></td>
			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>
		</tr>
		<c:forEach items="${sessionScope.bsnllist}" var="bsnlUser">

			<tr>

				<td>${bsnlUser.getBsnlId()}</td>
				<td>${bsnlUser.getPlanName()}</td>
				<td>${bsnlUser.getPrice()}</td>
				<td>${bsnlUser.getValidity()}</td>
				<td>${bsnlUser.getBenfits()}</td>
				<td>${bsnlUser.getOperator().getOperatorname()}</td>
				<td>${bsnlUser.getStatus()}</td>
				<td><a
					href="bsnlDelete.jsp?bsnlId=${bsnlUser.getBsnlId()}&planName=${bsnlUser.getPlanName()}&price=${bsnlUser.getPrice()}&validity=${bsnlUser.getValidity()}&benefits=${bsnlUser.getBenfits()}&operator=${bsnlUser.getOperator().getOperatorname()}">Edit</a></td>
				<td><a href="updateBsnl.jsp">Update</a>
			</tr>
		</c:forEach>
	</table>




</body>
</html>