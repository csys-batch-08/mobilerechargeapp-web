<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SelectAirtelPlan</title>
<link rel="stylesheet" type="text/css" href="assets/css/search.css"> 
</head>
<body>
	<form>
		<div class="header">
			<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="ContactUs.jsp">contactUs</a> <a href="index.jsp">Logout</a>
		</div>
	</form>
	
	
	<form>
		<div>
			<table aria-describedby="searchJioplan" style="width: 100%">

				<tr>

					<th><strong>PLANNAME</strong></th>
					<th><strong>PRICE</strong></th>
					<th><strong>VALIDITY</strong></th>
					<th><strong>BENEFITS</strong></th>
					<th><strong>OPERATOR</strong></th>
					
				</tr>
				

					<c:forEach items="${requestScope.airtelplan}" var="airtelUser">
					<tr>
						<td>${airtelUser.getPlanName()}</td>
						<td>${airtelUser.getPrice()}</td>
						<td>${airtelUser.getValidity()}</td>
						<td>${airtelUser.getBenfits()}</td>
						<td>${airtelUser.getOperator().getOperatorname()}</td>
					
						<td class="links"><a href="RechargeAirtelController?planName=${airtelUser.getPlanName()}&price=${airtelUser.getPrice()}&operator=${airtelUser.getOperator().getOperatorname()}"><button>RECHARGE</a></button></td>
						
				</tr>
				</c:forEach>

			</table>
		</div>
	</form>
	
	
	
</body>
</html>

