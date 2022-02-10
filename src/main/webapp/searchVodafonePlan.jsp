<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SelectVodafoneplan</title>
<link rel="stylesheet" type="text/css" href="assets/css/search.css">
</head>
<body>
	<form>
		<div class="header">
			<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="contactUs.jsp">ContactUs</a> <a href="index.jsp">Logout</a>
		</div>
	</form>
	<table aria-describedby="searchVodafoneplan" style="width: 100%">
		<tr>
			<th><strong>PLANNAME</strong></th>
			<th><strong>PRICE</strong></th>
			<th><strong>VALIDITY</strong></th>
			<th><strong>BENEFITS</strong></th>
			<th><strong>OPERATOR</strong></th>
		</tr>
		<c:forEach items="${requestScope.Vodafonelist}" var="vodafoneUser">
			<tr>
				<td>${vodafoneUser.getPlanName()}</td>
				<td>${vodafoneUser.getPrice()}</td>
				<td>${vodafoneUser.getValidity()}</td>
				<td>${vodafoneUser.getBenfits()}</td>
				<td>${vodafoneUser.getOperator().getOperatorname()}</td>
				<td class="links"><a
					href="RechargeVodafonecontroller?planName=${vodafoneUser.getPlanName()}&price=${vodafoneUser.getPrice()}&operator=${vodafoneUser.getOperator().getOperatorname()}"><button>RECHARGE</button></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
