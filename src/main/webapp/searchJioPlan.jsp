<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SelectJioplan</title>
<link rel="stylesheet" type="text/css" href="assets/css/search.css"> 
</head>

<body>
	<form>


		<div class="header">
			<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="ContactUs.jsp">ContactUs</a> <a href="index.jsp">Logout</a>
		</div>
		</form>
	
	
	<form>
		<div>
			<table  aria-describedby="searchjioplan"style="width: 100%">

				<tr>

					<th><strong>PLANNAME</strong></th>
					<th><strong>PRICE</strong></th>
					<th><strong>VALIDITY</strong></th>
					<th><strong>BENEFITS</strong></th>
					<th><strong>OPERATOR</strong></th>
					
				</tr>
				

					<c:forEach items="${requestScope.jioplan}" var="jioUser">
					<tr>
						<td>${jioUser.getPlanName()}</td>
						<td>${jioUser.getPrice()}</td>
						<td>${jioUser.getValidity()}</td>
						<td>${jioUser.getBenfits()}</td>
						<td>${jioUser.getOperator().getOperatorname()}</td>
					
						<td class="links"><a href="RechargeJioController?planName=${jioUser.getPlanName()}&price=${jioUser.getPrice()}&operator=${jioUser.getOperator().getOperatorname()}"><button>RECHARGE</a></button></td>
						
				</tr>
				</c:forEach>

			</table>
		</div>
	</form>

</body>
</html>