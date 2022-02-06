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

	<%
	String error = (String) session.getAttribute("balance");
	if (error != null) {
	%>
	<h1><%=error%></h1>
	<%
	session.removeAttribute("balance");
	%>
	<%
	}
	%>







	<!-- <div class="searchbar">
<form action="SearchBsnlController">
<label for="plan"></label>
<input type="text" name="bsnlplan" id="plan">
<input type="submit" value="search">
</div>

</form>

	<div class="header">
		<a href="Operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
			href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
		<a href="contectus.jsp">ContectUs</a> <a href="index.jsp">Logout</a>
	</div> -->
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
					<input type="search" name="bsnlplan" id="plan"> <label
						class="icon"> <span class="fas fa-search"></span>
					</label>
				</form>
			</li>
		</ul>
	</nav>



	<form>
		<div>
			<table style="width: 100%">

				<tr>

					<td><strong>PLANNAME</strong></td>
					<td><strong>PRICE</strong></td>
					<td><strong>VALIDITY</strong></td>
					<td><strong>BENEFITS</strong></td>
					<td><strong>OPERATOR</strong></td>

				</tr>


				<c:forEach items="${requestScope.bsnllist}" var="bsnlUser">
					<tr>
						<td>${bsnlUser.getPlanName()}</td>
						<td>${bsnlUser.getPrice()}</td>
						<td>${bsnlUser.getValidity()}</td>
						<td>${bsnlUser.getBenfits()}</td>
						<td>${bsnlUser.getOperator().getOperatorname()}</td>
						<td class="links"><a
							href="RechargeBsnlController?planName=${bsnlUser.getPlanName()}&price=${bsnlUser.getPrice()}&operator=${bsnlUser.getOperator().getOperatorname()}"><button>RECHARGE</a>
							</button></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form>


</body>
</html>