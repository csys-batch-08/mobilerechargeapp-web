<%@page import="java.sql.ResultSet"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>UserHistoryDetails</title>
<link rel="stylesheet" type="text/css" href="assets/css/history.css">


</head>
<body>


	<div class="header">
		<a href="operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
			href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
		<a href="ContactUs.jsp">ContactUs</a> <a href="index.jsp">Logout</a>
	</div>



	<h1>HISTORY DETAILS</h1>

	<table aria-describedby="UserHistory" style="width: 100%">
		<tr>

			<th><strong>OPERATOR NAME</strong></th>
			<th><strong>PLAN ID</strong></th>
			<th><strong>RECHARGE DATE</strong></th>
			<th><strong>PAYMENT</strong></th>
			<th><strong>MOBILE NUMBER</strong></th>
		</tr>
		<c:forEach items="${sessionScope.List}" var="list">
			<tr>
				<td>${list.get(0)}</td>
				<td>${list.get(1)}</td>
			
				<td>${list.get(2)}</td>
				<td><fmt:parseDate value="${list.get(3)}" pattern="yyyy-MM-dd"
						var="macthDate" type="date" /> <fmt:formatDate
						pattern="dd/MM/yyyy" value="${macthDate}" /></td>
				<%-- 	<td>${list.get(3)} </td> --%>
				<td>${list.get(4)}</td>

			</tr>
		</c:forEach>
	</table>

	<%-- <div >
<c:forEach items="${sessionScope.List}" var="list">
<ul class="singleCard">

<li>OPERATOR NAME:${list.get(0)}</li>
<li>MOBILE NUMBER:${list.get(1)}</li>
<li>PLAN ID:${list.get(2)}</li>
<li>RECHARGE DATE:${list.get(3)}</li>
<li>PAYMENT:${list.get(4)}</li>

</ul>
</c:forEach>
</div> --%>
</body>
</html>