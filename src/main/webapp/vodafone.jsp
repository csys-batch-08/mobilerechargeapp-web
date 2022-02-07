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
 



	<table aria-describedby="AdminPlanVodafone" style="width:100%;">

		<tr>

			<th><strong>PLANID</strong></th>
			<th><strong>PLANNAME</strong></th>
			<th><strong>PRICE</strong></th>
			<th><strong>VALIDITY</strong></th>
			<th><strong>BENEFITS</strong></th>
			<th><strong>OPERATOR</strong></th>

			<c:forEach items="${requestScope.vodafonelist}" var="vodafoneUser">

				<tr>
					
                     <td>${vodafoneUser.getVodafoneId()}</td>
					<td>${vodafoneUser.getPlanName()}</td>
					<td>${vodafoneUser.getPrice()}</td>
					<td>${vodafoneUser.getValidity()}</td>
					<td>${vodafoneUser.getBenfits()}</td>
					<td>${vodafoneUser.getOperator().getOperatorname()}</td>
					<td>${vodafoneUser.getStatus()}</td>
					<td><a href="vodafoneDelete.jsp?vodfoneId=${vodafoneUser.getVodafoneId()}&planName=${vodafoneUser.getPlanName()}&price=${vodafoneUser.getPrice()}&validity=${vodafoneUser.getValidity()}&benefits=${vodafoneUser.getBenfits()}&operator=${vodafoneUser.getOperator().getOperatorname()}">Edit</a></td>
					<td><a href="updateVodafone.jsp">Update</a>
				</tr>
			</c:forEach>
	</table>



</body>
</html>