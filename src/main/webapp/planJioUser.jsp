<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="assets/css/plan.css">
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
<head>
<meta charset="ISO-8859-1">
<title>ShowplanJio</title>
<body>
	<%-- <c:set var = "balanceinfo" scope = "session" value = "${balance}"/>
<c:if test="${not empty balanceinfo}">
			<h2><c:out value="${balanceinfo}" /></h2>
			 <c:remove var="balanceinfo" scope="session" />
		</c:if> --%>
	<c:if test="${balancejio!=null }">
		<h2>${balancejio}</h2>
		<c:remove var="balancejio" scope="session" />
	</c:if>
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
				<form action="SearchJioPlanController">
					<input type="search" name="jioplan" aria-label="jioplan"> <label
						class="icon"> <span class="fas fa-search"></span>
					</label>
				</form>
			</li>
		</ul>
	</nav>
	<table aria-describedby="PlanJio" style="width: 100%">
		<tr>
			<th scope="col"><strong>PLANNAME</strong></th>
			<th scope="col"><strong>PRICE</strong></th>
			<th scope="col"><strong>VALIDITY</strong></th>
			<th scope="col"><strong>BENEFITS</strong></th>
			<th scope="col"><strong>OPERATOR</strong></th>
		</tr>
		<c:forEach items="${requestScope.jiolist}" var="jioUser">
			<tr>
				<td>${jioUser.getPlanName()}</td>
				<td>${jioUser.getPrice()}</td>
				<td>${jioUser.getValidity()}</td>
				<td>${jioUser.getBenfits()}</td>
				<td>${jioUser.getOperator().getOperatorname()}</td>
				<td class="links"><a
					href="RechargeJioController?planName=${jioUser.getPlanName()}&price=${jioUser.getPrice()}&operator=${jioUser.getOperator().getOperatorname()}"><button>RECHARGE</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>