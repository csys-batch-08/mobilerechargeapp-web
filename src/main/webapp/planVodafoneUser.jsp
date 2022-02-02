<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
<title>ShowPlanVodafone</title>

<link rel="stylesheet" type="text/css" href="assets/css/plan.css"> 
</head>


<body>

 <c:if test="${balanceVodafone!=null }">
        <h2>${balanceVodafone}</h2>
        <c:remove var="balanceVodafone" scope="session" />
        </c:if> 





	<!-- <div class="searchbar">
<form action="SearchVodafoneController">
<label for="plan"></label>
<input type="text" name="Viplan" id="plan">
<input type="submit" value="search">
</div>

</form>

	<div class="header">
		<a href="wallet.jsp">wallet</a> <a href="history.jsp">RechargeHistory</a>
		<a href="aboutus.jsp">AboutUs</a> <a href="contectus.jsp">ContectUs</a>
		<a href="index.jsp">Logout</a>
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
				<form action="SearchVodafoneController">
					<input type="search" name="Viplan" id="plan"> <label
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


				<c:forEach items="${sessionScope.Vodafonelist}" var="vodafoneUser">
					<tr>
						<td>${vodafoneUser.getPlanName()}</td>
						<td>${vodafoneUser.getPrice()}</td>
						<td>${vodafoneUser.getValidity()}</td>
						<td>${vodafoneUser.getBenfits()}</td>
						<td>${vodafoneUser.getOperator().getOperatorname()}</td>
						<td class="links"><a
							href="RechargeVodafonecontroller?planName=${vodafoneUser.getPlanName()}&price=${vodafoneUser.getPrice()}&operator=${vodafoneUser.getOperator().getOperatorname()}"><button>RECHARGE</a>
						</button></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form>

</body>
</html>