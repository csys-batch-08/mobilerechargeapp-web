<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SelectVodafoneplan</title>
<link rel="stylesheet" type="text/css" href="assets/css/search.css"> 
</head>
<body>
<form>
		<div class="header">
			<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="contactUs.jsp">ContactUs</a> <a href="index.jsp">Logout</a>
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
<%-- <table style="width: 100%">
		<tr>

			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>


		</tr>
		<%
          
		List<VodafoneUser> vodafoneUser=(List<VodafoneUser>)session.getAttribute("list");	
			for(int i=0;i<vodafoneUser.size();i++)
			{
			VodafoneUser vodafoneUser1=vodafoneUser.get(i);
	
	
           %>

		<tr>
			<td><%= vodafoneUser1.getPlanName() %></td>
			<td><%= vodafoneUser1.getPrice() %></td>
			<td><%=vodafoneUser1.getValidity() %></td>
			<td><%= vodafoneUser1.getBenfits() %></td>
			<td><%= vodafoneUser1.getOperator().getOperatorname() %></td>
			<td class="links"><a
				href="recharge.jsp?planName=<%=vodafoneUser1.getPlanName() %>&price=<%= vodafoneUser1.getPrice() %>
&operator=<%= vodafoneUser1.getOperator().getOperatorname() %>"><button>Recharge</a>
				</button></td>
		</tr>

		<%}%>
	</table> --%>
