<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selectjioplan</title>
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
			<a href="Operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="contectus.jsp">ContectUs</a> <a href="logout.jsp">Logout</a>
		</div>
	</form>
	<table style="width: 100%">
		<tr>

			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>


		</tr>
		<%List<JioUser> user=(List<JioUser>)session.getAttribute("list"); 
		  for(int i=0;i<user.size();i++)
		  {
			  JioUser jioSearch=user.get(i); 
		%>



		<tr>
			<td><%= jioSearch.getPlanName() %></td>
			<td><%= jioSearch.getPrice() %></td>
			<td><%= jioSearch.getValidity() %></td>
			<td><%= jioSearch.getBenfits() %></td>
			<td><%= jioSearch.getOperator().getOperatorname() %></td>
			<td class="links"><a
				href="recharge.jsp?planName=<%=jioSearch.getPlanName() %>&price=<%= jioSearch.getPrice() %>
&operator=<%= jioSearch.getOperator().getOperatorname() %>"><button>Recharge</a>
				</button></td>
		</tr>

		<%}%>
	</table>

</body>
</html>