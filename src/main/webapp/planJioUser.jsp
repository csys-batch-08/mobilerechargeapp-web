<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>

<title>ShowplanJio</title>
<link rel="stylesheet" type="text/css" href="assets/css/plan.css"> 

<body>


	<%-- <%String error=(String)session.getAttribute("balance");
if(error!=null){
%>
	<h1><%=error %></h1>
	<%session.removeAttribute("balance"); %>
	<%} %> --%>
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
					<input type="search" name="jioplan" id="plan"> <label
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
				

					<c:forEach items="${sessionScope.jiolist}" var="jioUser">
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