<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirtelNetwork</title>
</head>
<style type="text/css">

table {
    background: cornflowerblue;
    padding: 10px;
}
table, tr, td {
    text-align: center;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
}
tr:nth-child(even) {
    background-color: #3f56fb;
    color: white;
    padding: 10px;
    margin-left: 19px; 
}
td.links {
    text-align: center;
}

td.links a {
    color:maroon;
    text-decoration: none;
    font-weight: bold;
    font-family: sans-serif;
    font-size: 15px;
   /*  background: aliceblue; */
    padding: 9px;
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
    justify-content: flex-end;   
}
.header a:hover {
    background: white;
    color: black;
}

}</style>
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


<table style="width: 100%">
		<tr>

			<td><strong>PLANID</strong></td>
			<td><strong>PLANNAME</strong></td>
			<td><strong>PRICE</strong></td>
			<td><strong>VALIDITY</strong></td>
			<td><strong>BENEFITS</strong></td>
			<td><strong>OPERATOR</strong></td>

			<c:forEach items="${sessionScope.airtellist}" var="airtelUser">

				<tr>
					
                     <td>${airtelUser.getAirtelId()}</td>
					<td>${airtelUser.getPlanName()}</td>
					<td>${airtelUser.getPrice()}</td>
					<td>${airtelUser.getValidity()}</td>
					<td>${airtelUser.getBenfits()}</td>
					<td>${airtelUser.getOperator().getOperatorname()}</td>
					<td><a href="DeleteairtelController?airtelId=${airtelUser.getAirtelId()}">Delete</a></td>
					<td><a href="updateJio.jsp">Edit</a>
				</tr>
			</c:forEach>
	</table>
</body>
</html>