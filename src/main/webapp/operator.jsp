
<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@page import="java.util.Date"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="com.mobilerechargeapp.model.Operator"%>
<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SELECTYOURNETWORK</title>
<link rel="stylesheet" type="text/css" href="assets/css/operator.css"> 
</head>
<body>
<c:if test="${amount!=null }">
        <h3>AvailableBalance:${amount}</h3>
        </c:if>


<%--  <%Double Amount=(Double)session.getAttribute("amount");
 if(Amount!=null){
 %>
 <h3>AvailableBalance:<%=Amount %></h3>
 <%} %> --%>
 <div>
<!--   <h1 style="text-align:center">SELECT YOUR NETWORK</h1> -->
  </div>
<div class="header">
<a href="operator.jsp">Home</a>
<a href="wallet.jsp">wallet</a>
<a href="ViewHistoryController">RechargeHistory</a>
<a href="aboutus.jsp">AboutUs</a>
<a href="ContactUs.jsp">ContactUs</a>

<a href="index.jsp">Logout</a>
</div>
<div align="center">
 
<div class="singleCard">
<a href="planJioUser"><b>Jio</b></a>
<img src="images/jiologo.jpg">
</div>
	<div class="singleCard">
	<a href="planAirtelUser"><b>Airtel</b></a>
	<img src="images/airtel logo.png">
	</div>
	<div class="singleCard">
	<a href="planVodafoneUser"><b>vodafone</b></a>
	<img src="images/VI-Logo-PNG.jpg">
	</div>
	<div class="singleCard">
	<a href="planBsnlUser"><b>Bsnl</b></a>
	<img src="images/BSNL logo.png">
	</div>
</div>



<c:if test="${validity!=null }">
    <h1>${validity} days remaining validity only</h1> 
        </c:if>



</body>
</html>