<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>selectBsnlplan</title>
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
			<table aria-describedby="searchBsnlplan" style="width: 100%">
				<tr>
					<th><strong>PLANNAME</strong></th>
					<th><strong>PRICE</strong></th>
					<th><strong>VALIDITY</strong></th>
					<th><strong>BENEFITS</strong></th>
					<th><strong>OPERATOR</strong></th>
				</tr>
				<c:forEach items="${requestScope.bsnlplan}" var="bsnlUser">
					<tr>
						<td>${bsnlUser.getPlanName()}</td>
						<td>${bsnlUser.getPrice()}</td>
						<td>${bsnlUser.getValidity()}</td>
						<td>${bsnlUser.getBenfits()}</td>
						<td>${bsnlUser.getOperator().getOperatorname()}</td>
						<td class="links"><a
							href="RechargeBsnlController?planName=${bsnlUser.getPlanName()}&price=${bsnlUser.getPrice()}&operator=${bsnlUser.getOperator().getOperatorname()}">
								<button>RECHARGE</button>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>

