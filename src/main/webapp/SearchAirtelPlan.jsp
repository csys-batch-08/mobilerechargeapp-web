<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SelectAirtelPlan</title>
<style>
body {
	overflow: hidden;
}

table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	padding: 10px;
	position: absolute;
	top: 70px;
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
	padding: 10px;
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

.header a {
	padding: 12px 18px;
	text-decoration: none;
	font-weight: bold;
	color: white;
}

.header {
	background: linear-gradient(to right, #3f56fb, #fc466b);
	padding: 0px;
	display: flex;
	justify-content: space-around;
	position: absolute;
	top: 30px;
	width: 100%;
}

.header a:hover {
	background: white;
	color: black;
}
</style>
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
			<table style="width: 100%">

				<tr>

					<td><strong>PLANNAME</strong></td>
					<td><strong>PRICE</strong></td>
					<td><strong>VALIDITY</strong></td>
					<td><strong>BENEFITS</strong></td>
					<td><strong>OPERATOR</strong></td>
					
				</tr>
				

					<c:forEach items="${sessionScope.airtelplan}" var="airtelUser">
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
<%-- <table style="width: 100%">
		<tr>

			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>


		</tr>
		<%
		List<AirtelUser> airtelUser = (List<AirtelUser>) session.getAttribute("list");
		for (int i = 0; i < airtelUser.size(); i++) {
			AirtelUser airtelSearch = airtelUser.get(i);
		%>

		<tr>
			<td><%=airtelSearch.getPlanName()%></td>
			<td><%=airtelSearch.getPrice()%></td>
			<td><%=airtelSearch.getValidity()%></td>
			<td><%=airtelSearch.getBenfits()%></td>
			<td><%=airtelSearch.getOperator().getOperatorname()%></td>
			<td class="links"><a
				href="recharge.jsp?planName=<%=airtelSearch.getPlanName()%>&price=<%=airtelSearch.getPrice()%>
&operator=<%=airtelSearch.getOperator().getOperatorname()%>"><button>Recharge</a>
		</tr>

		<%
		}
		%>
	</table> --%>
