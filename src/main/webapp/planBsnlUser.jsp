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
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>

<title>selectBsnlPlans</title>
<link rel="stylesheet" type="text/css" href="assets/css/plan.css">
</head>
<body>
	<nav>
		<ul>
			<div class="header">
				<li><a href="operator.jsp">Home</a></li>
				<li><a href="wallet.jsp">wallet</a></li>
				<li><a href="history.jsp">RechargeHistory</a></li>
				<li><a href="aboutus.jsp">AboutUs</a></li>
				<li><a href="contactus.jsp">ContactUs</a></li>
				<li><a href="index.jsp">Logout</a></li>
			</div>
			<li class="search-icon">
				<form action="SearchBsnlController">
					<input type="search" name="bsnlplan" aria-label="bsnlplan">
					<label class="icon"> <span class="fas fa-search"></span>
					</label>
				</form>
			</li>
		</ul>
	</nav>
	<div style="text-align: center;">
		<c:if test="${balanceBsnl!=null }">
			<h2>${balanceBsnl}</h2>
			<c:remove var="balanceBsnl" scope="session" />
		</c:if>
	</div>
	<table aria-describedby="PlanBsnl" style="width: 100%">
		<tr>
			<th scope="col"><strong>PLANNAME</strong></th>
			<th scope="col"><strong>PRICE</strong></th>
			<th scope="col"><strong>VALIDITY</strong></th>
			<th scope="col"><strong>BENEFITS</strong></th>
			<th scope="col"><strong>OPERATOR</strong></th>
		</tr>
		<c:forEach items="${requestScope.bsnllist}" var="bsnlUser">
			<tr>
				<td>${bsnlUser.getPlanName()}</td>
				<td>${bsnlUser.getPrice()}</td>
				<td>${bsnlUser.getValidity()}</td>
				<td>${bsnlUser.getBenfits()}</td>
				<td>${bsnlUser.getOperator().getOperatorname()}</td>
				<td class="links"><a
					href="RechargeBsnlController?planName=${bsnlUser.getPlanName()}&price=${bsnlUser.getPrice()}&operator=${bsnlUser.getOperator().getOperatorname()}"><button>RECHARGE</button></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>