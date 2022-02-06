<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SelectJioplan</title>
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
	<%-- </form>
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
	</table> --%>
	
	
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
				

					<c:forEach items="${sessionScope.jioplan}" var="jioUser">
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