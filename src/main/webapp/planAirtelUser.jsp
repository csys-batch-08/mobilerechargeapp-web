<%@page import="com.mobilerechargeapp.model.AirtelUser"%>

<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
<title>ShowAirtelPlan</title>

<link rel="stylesheet" type="text/css" href="assets/css/plan.css">
</head>

<body>

	<%-- 
	<%String error=(String)session.getAttribute("balance");
if(error!=null){
%>
	<h1><%=error %></h1>
	<%session.removeAttribute("balance"); %>
	<%} %> --%>
	<c:if test="${balanceAirtel!=null }">
		<h2>${balanceAirtel}</h2>
		<c:remove var="balanceAirtel" scope="session" />
	</c:if>



	<nav>
		<ul>
			<div class="header">
				<li><a href="operator.jsp">Home</a></li>
				<li><a href="wallet.jsp">wallet</a></li>
				<li><a href="history.jsp">RechargeHistory</a></li>
				<li><a href="aboutus.jsp">AboutUs</a></li>
				<li><a href="contactus.jsp">ContectUs</a></li>
				<li><a href="index.jsp">Logout</a></li>
			</div>
			<li class="search-icon">
				<form action="SearchAirtelPlanController">
					<input type="search" name="airtelplan" id="plan"> <label
						class="icon"> <span class="fas fa-search"></span>
					</label>
				</form>
			</li>
		</ul>
	</nav>




	<table aria-describedby="PlanAirtel" style="width: 100%;">

		<tr>

			<th scope="col"><strong>PLANNAME</strong></th>
			<th scope="col"><strong>PRICE</strong></th>
			<th scope="col"><strong>VALIDITY</strong></th>
			<th scope="col"><strong>BENEFITS</strong></th>
			<th scope="col"><strong>OPERATOR</strong></th>

		</tr>


		<c:forEach items="${requestScope.airtellist}" var="airtelUser">
			<tr>
				<td>${airtelUser.getPlanName()}</td>
				<td>${airtelUser.getPrice()}</td>
				<td>${airtelUser.getValidity()}</td>
				<td>${airtelUser.getBenfits()}</td>
				<td>${airtelUser.getOperator().getOperatorname()}</td>
				<td class="links"><a
					href="RechargeAirtelController?planName=${airtelUser.getPlanName()}&price=${airtelUser.getPrice()}&operator=${airtelUser.getOperator().getOperatorname()}"><button>RECHARGE</button></a></td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>