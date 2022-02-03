<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>s
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>VodafoneNetwork</title>
<link rel="stylesheet" type="text/css" href="assets/css/planAdmin.css"> 
</head>
<body style="text-align: center;">
<div class="header">
<a href="adminHome.jsp">ADMIN</a>
<a href="addJio.jsp"> JIO </a>
<a href="addAirtel.jsp">AIRTEL</a>
<a href="addVodafone.jsp">VODAFONE</a>
<a href="addBsnl.jsp">BSNL</a>

<a href="index.jsp">LOGOUT</a>

</div>



<h1><strong>VODAFONE NETWORK</strong></h1>
 



<table style="width: 100%">
		<tr>

			<td><strong>PLANID</strong></td>
			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>

			<c:forEach items="${sessionScope.vodafonelist}" var="vodafoneUser">

				<tr>
					
                     <td>${vodafoneUser.getVodafoneId()}</td>
					<td>${vodafoneUser.getPlanName()}</td>
					<td>${vodafoneUser.getPrice()}</td>
					<td>${vodafoneUser.getValidity()}</td>
					<td>${vodafoneUser.getBenfits()}</td>
					<td>${vodafoneUser.getOperator().getOperatorname()}</td>
					<td><a href="DeletevodafoneController?vodfoneId=${vodafoneUser.getVodafoneId()}">Delete</a></td>
					<td><a href="updateVodafone.jsp">Edit</a>
				</tr>
			</c:forEach>
	</table>



</body>
</html>