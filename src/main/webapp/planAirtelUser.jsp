<%@page import="com.mobilerechargeapp.model.AirtelUser"%>

<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
<title>ShowAirtelPlan</title>
</head>
<style type="text/css">
table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	position: absolute;
	padding: 10px;
	top: 100px;
}

table, tr, td {
	text-align: center;
	height: 40px;
	padding: 3px 10px;
	margin-top: 10px;
	font-size: medium;
}

tr:nth-child(even) {
	background-color: #3f56fb;
	color: white;
	padding: 10px; 5
	margin-left: 19px;
}

tr:hover {
	background-color: threedlightshadow;
}

td.links {
	text-align: center;
}

td.links a {
	color: rgba(#3f56fb, #fc466b);
	text-decoration: none;
	font-weight: bold;
	font-family: sans-serif;
	font-size: 15px;
	/*  background: aliceblue; */
	padding: 9px;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: sans-serif;
}

nav {
	/* background: #222222; */
	background: linear-gradient(to right, #3f56fb, #fc466b);
	padding: 10px 40px 10px 70px;
	border: 1px solid red;
	border-left: none;
	border-right: none;
}

nav ul {
	display: flex;
	list-style: none;
	flex-wrap: wrap;
	align-items: center;
	justify-content: flex-end;
}

nav ul div.header {
	padding: 0 25px;
	display: inline-flex;
}

nav ul div.header a {
	text-decoration: none;
	font-size: 18px;
	padding: 12px 28px;
	font-weight: bold;
	color: white;
}

nav ul div.header a:hover {
	background: white;
	color: black;
}

nav ul .search-icon {
	height: 40px;
	width: 240px;
	display: flex;
	background: #f2f2f2;
	border-radius: 5px;
}

nav ul .search-icon input {
	height: 100%;
	width: 200px;
	border: none;
	outline: none;
	padding: 0 10px;
	color: #000;
	font-size: 16px;
	border-radius: 5px 0 0 5px;
}

nav ul .search-icon .icon {
	height: 100%;
	width: 40px;
	line-height: 40px;
	text-align: center;
	border: 1px solid #cccccc;
	border-radius: 0 5px 5px 0;
}

nav ul .search-icon .icon:hover {
	background: #e6e6e6;
}

nav ul .search-icon .icon span {
	color: #222222;
	font-size: 18px;
}
</style>
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


				<c:forEach items="${sessionScope.airtellist}" var="airtelUser">
					<tr>
						<td>${airtelUser.getPlanName()}</td>
						<td>${airtelUser.getPrice()}</td>
						<td>${airtelUser.getValidity()}</td>
						<td>${airtelUser.getBenfits()}</td>
						<td>${airtelUser.getOperator().getOperatorname()}</td>
						<td class="links"><a
							href="RechargeAirtelController?planName=${airtelUser.getPlanName()}&price=${airtelUser.getPrice()}&operator=${airtelUser.getOperator().getOperatorname()}"><button>RECHARGE</a>
						</button></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form>

</body>
</html>