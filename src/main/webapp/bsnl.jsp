<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bsnlShowPlan</title>
<style type="text/css">
table {
	background: cornflowerblue;
	padding: 10px;
}

table, tr, td {
	text-align: left;
	height: 40px;
	padding: 3px 10px;
	margin-top: 10px;
	text-align: center;
}

tr:nth-child(even) {
	background-color: #3f56fb;
	color: white;
	padding: 10px;
	margin-left: 19px;
}

td.links {
	text-align: center;
}

td.links a {
	color: maroon;
	text-decoration: none;
	font-weight: bold;
	font-family: sans-serif;
	font-size: 15px;
	/*  background: aliceblue; */
	padding: 9px;
}

.header a {
	padding: 12px 28px;
	text-decoration: none;
	font-weight: bold;
	color: white;
	border-bottom-right-radius: 10em;
}

.header {
	background: linear-gradient(to right, #3f56fb, #fc466b);
	padding: 0px;
	display: flex;
	justify-content: flex-end;
}

.header a:hover {
	background: white;
	color: black;
}
}
</style>
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
				<td><a
					href="DeletebsnlController?bsnlId=${bsnlUser.getBsnlId()}">Delete</a></td>
				<td><a href="updateJio.jsp">Edit</a>
			</tr>
		</c:forEach>
	</table>




</body>
</html>