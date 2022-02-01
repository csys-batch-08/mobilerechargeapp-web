<%@page import="java.sql.ResultSet"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHistoryDetails</title>
<style type="text/css">
BODY {
background-image: url("images/backimg.jpg");

}
* {
margin:0;
padding:0;
box-sizing: border-box;
font-family: sans-serif;
}

body {
	overflow: hidden;
	
}

table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	padding: 10px;
	position: absolute;
	top: 70px;
}

table, tr, td {
	text-align: left;
	height: 40px;
	padding: 3px 10px;
	margin-top: 10px;
	font-size: medium;
	text-align: center;
}

tr:nth-child(even) {
 	background-color:blue;
    color: white;
	padding: 10px;
	margin-left: 19px;
}

tr:hover {
	background-color: threedlightshadow;
}


.header a {
    padding: 12px 28px;
    text-decoration: none;
    font-weight: bold;
    color: white;
    border-bottom-right-radius: 10em;
   
}

.header {
    background: linear-gradient(to right, #3f56fb, #fc466b);
    padding: 0px;
    display: flex;
    justify-content: space-around;
    
   
}
.header a:hover {
    background: white;
    color: black;
}
h1 {
text-align: center;
font-weight: bold;
font-family: sans-serif; 
}
/* .singleCard {
    width: 100%;
    display:inline-flex;
    background:white;
    justify-content: space-between;
    padding: 10px;
    align-items: center;
    box-shadow: white;
    margin-top: 13px;
    border-radius: 4px;
    }  */
</style>

</head>
<body >

<div class="header">
<a href="operator.jsp">Home</a>
<a href="wallet.jsp">wallet</a>
<a href="history.jsp">RechargeHistory</a>
<a href="aboutus.jsp">AboutUs</a>
<a href="ContactUs.jsp">ContactUs</a>

<a href="index.jsp">Logout</a>
</div>



	<h1>HISTORY DETAILS</h1>

	 
	
	
	
	

	<table style="width:100%">
		<tr>
			
			<td><strong>OPERATOR NAME</strong></td>
			<td><strong>PLAN ID</strong></td>
			<td><strong>RECHARGE DATE</strong></td>
			<td><strong>PAYMENT</strong></td>
			<td><strong>MOBILE NUMBER</strong></td>
		</tr>
	<c:forEach items="${sessionScope.List}" var="list">
		<tr>
			<td>${list.get(0)} </td>
			<td>${list.get(1)}</td>
			<td>${list.get(2)}</td>
			<td>${list.get(3)} </td>
			<td>${list.get(4)} </td>
	
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