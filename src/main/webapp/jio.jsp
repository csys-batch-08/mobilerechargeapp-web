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


	<table style="width:100%;">
	
<tr>
			<th><strong>PLANID</strong></th>
			<th><strong>PLANNAME</strong></th>
			<th><strong>PRICE</strong></th>
			<th><strong>VALIDITY</strong></th>
			<th><strong>BENEFITS</strong></th>
			<th><strong>OPERATOR</strong></th>
</tr>
			<c:forEach items="${requestScope.jiolist}" var="jioUserList">

				<tr>
					
                     <td>${jioUserList.getJioId()}</td>
					<td>${jioUserList.getPlanName()}</td>
					<td>${jioUserList.getPrice()}</td>
					<td>${jioUserList.getValidity()}</td>
					<td>${jioUserList.getBenfits()}</td>
					<td>${jioUserList.getOperator().getOperatorname()}</td>
					<td>${jioUserList.getStatus()}</td>
					<td><a href="jioDelete.jsp?jioId=${jioUserList.getJioId()}&planName=${jioUserList.getPlanName()}&price=${jioUserList.getPrice()}&validity=${jioUserList.getValidity()}&benefits=${jioUserList.getBenfits()}&operator=${jioUserList.getOperator().getOperatorname()}">Delete</a></td>
					<td><a href="updateJio.jsp">Edit</a>
					
				</tr>
			</c:forEach>
	</table>





</body>
</html>