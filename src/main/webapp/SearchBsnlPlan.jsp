<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>selectBsnlplan</title>
</head>
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
<body>
	<form>


		<div class="header">
			<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="ContactUs.jsp">ContactUs</a> <a href="index.jsp">Logout</a>
		</div>
	</form>
	<form>
		<table style="width: 100%">
			<tr>

				<td><strong>PLANNAME</strong></td>
				<td><strong>PRICE</strong></td>
				<td><strong>VALIDITY</strong></td>
				<td><strong>BENEFITS</strong></td>
				<td><strong>OPERATOR</strong></td>
				<%
				List<BsnlUser> user = (List<BsnlUser>) session.getAttribute("list");

				for (int i = 0; i < user.size(); i++) {
					BsnlUser bsnlUser = user.get(i);
				%>
			
			<tr>
				<td><%=bsnlUser.getPlanName()%></td>
				<td><%=bsnlUser.getPrice()%></td>
				<td><%=bsnlUser.getValidity()%></td>
				<td><%=bsnlUser.getBenfits()%></td>
				<td><%=bsnlUser.getOperator().getOperatorname()%></td>
				<td class="links"><a
					href="recharge.jsp?planName=<%=bsnlUser.getPlanName()%>&price=<%=bsnlUser.getPrice()%>
&operator=<%=bsnlUser.getOperator().getOperatorname()%>"><button>Recharge</a></button></td>
			</tr>
			<%
			}
			%>

		</table>
	</form>
</body>
</html>