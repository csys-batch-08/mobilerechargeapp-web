<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AirtelNetwork</title>
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


 <h1>AIRTEL NETWORK</h1>


	<table style="width:100%;">

		<tr>

			<td><strong>PLANID</strong></td>
			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>
 </tr>
			<c:forEach items="${requestScope.airtellist}" var="airtelUser">

				<tr>
                    <td>${airtelUser.getAirtelId()}</td>
					<td>${airtelUser.getPlanName()}</td>
					<td>${airtelUser.getPrice()}</td>
					<td>${airtelUser.getValidity()}</td>
					<td>${airtelUser.getBenfits()}</td>
					<td>${airtelUser.getOperator().getOperatorname()}</td>
					<td>${airtelUser.getStatus()}</td>
					<td><a href="airtelDelete.jsp?airtelId=${airtelUser.getAirtelId()}&planName=${airtelUser.getPlanName()}&price=${airtelUser.getPrice()}&validity=${airtelUser.getValidity()}&benefits=${airtelUser.getBenfits()}&operator=${airtelUser.getOperator().getOperatorname()}">Delete</a></td>
					<td><a href="updateAirtel.jsp">Edit</a>
				</tr>
			</c:forEach>
	</table>
</body>
</html>