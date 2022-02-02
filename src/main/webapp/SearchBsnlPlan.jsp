<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
			<table style="width: 100%">

				<tr>

					<td><strong>PLANNAME</strong></td>
					<td><strong>PRICE</strong></td>
					<td><strong>VALIDITY</strong></td>
					<td><strong>BENEFITS</strong></td>
					<td><strong>OPERATOR</strong></td>

				</tr>


				<c:forEach items="${sessionScope.bsnlplan}" var="bsnlUser">
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
<%-- 	<form>
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
	</form> --%>
