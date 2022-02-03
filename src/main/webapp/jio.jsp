<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>JioNetwork</title>
<link rel="stylesheet" type="text/css" href="assets/css/planAdmin.css"> 

</head>
<c:if test="${add!=null }">
        <h3>JIO PLAN ADDED SUCESSFULLY</h3>
        </c:if>

<body style="text-align: center;">
	<div class="header">
		<a href="adminHome.jsp">ADMIN</a> <a href="addJio.jsp"> JIO </a> <a
			href="addAirtel.jsp">AIRTEL</a> <a href="addVodafone.jsp">VODAFONE</a>
		<a href="addBsnl.jsp">BSNL</a> <a href="index.jsp">LOGOUT</a>

	</div>


	<h1>
		<strong>JIO NETWORK</strong>
	</h1>

	<!-- <table style="width:100%" >
    <tr>
    <td><strong>PLANID</strong></td>
    <td><strong>PLANNAME</strong></td>
    <td><strong>PRICE</strong></td>
    <td><strong>VALIDITY</strong></td>
    <td><strong>BENEFITS</strong></td>
  	<td><strong>OPERATOR</strong></td>
  -->

	<%-- 	</tr>
<%
JioDAOImpl jioDao=new JioDAOImpl();
 List<JioUser>ShowPlan=jioDao.showJioplan();
 for(int i=0;i<ShowPlan.size();i++)
 {
   JioUser jioUser=ShowPlan.get(i);
    int findjioId=jioDao.findjioId(jioUser.getPlanName(),jioUser.getPrice());
 	%>
 	


  

<tr>
<td><%= findjioId %></td>
<td><%= jioUser.getPlanName() %></td>
<td><%= jioUser.getPrice() %></td>
<td><%= jioUser.getValidity() %></td>
<td><%= jioUser.getBenfits() %></td>
<td><%= jioUser.getOperator().getOperatorname() %></td>
<td><a href="deleteplan?jioId=<%= findjioId %>">delete</a></td>
<td><a href="updateJio.jsp">Edit</a>

</tr>
<%}%> --%>
	<table style="width: 100%">
		<tr>

			<td><strong>PLANID</strong></td>
			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>
</tr>
			<c:forEach items="${sessionScope.jiolist}" var="jioUser">

				<tr>
					
                     <td>${jioUser.getJioId()}</td>
					<td>${jioUser.getPlanName()}</td>
					<td>${jioUser.getPrice()}</td>
					<td>${jioUser.getValidity()}</td>
					<td>${jioUser.getBenfits()}</td>
					<td>${jioUser.getOperator().getOperatorname()}</td>
					<td><a href="deleteplan?jioId=${jioUser.getJioId()}">Delete</a></td>
					<td><a href="updateJio.jsp">Edit</a>
				</tr>
			</c:forEach>
	</table>





</body>
</html>