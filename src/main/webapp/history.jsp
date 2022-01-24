<%@page import="java.sql.ResultSet"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHistoryDetails</title>
<style type="text/css">
BODY{
background-image: url("images/blur-background-2.jpg");

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
</style>
</head>
<body >

<div class="header">
<a href="Operator.jsp">Home</a>
<a href="wallet.jsp">wallet</a>
<a href="history.jsp">RechargeHistory</a>
<a href="aboutus.jsp">AboutUs</a>
<a href="contectus.jsp">ContectUs</a>

<a href="index.jsp">Logout</a>
</div>



	<h1>History Details</h1>
	<%
	User user = (User)session.getAttribute("CurrentUser");
	/*   HistoryDetails history=(HistoryDetails)session.getAttribute("history"); */
	  
	
	HistorydetailsDAOImpl historyDao = new HistorydetailsDAOImpl();
	/*  List<HistoryDetails>history=historyDao.showHistoryDetails(); */
	
	
	
	UserDAOImpl userDao = new UserDAOImpl();

	
	ResultSet rs = userDao.history(user.getUserId());
	
	
	%> 
	
	
	
	 <%=user.getUserId()%> 
	<%-- <%
	 HistoryDetails history=(HistoryDetails)session.getAttribute("history");
	HistorydetailsDAOImpl historyDao = new HistorydetailsDAOImpl();
	UserDAOImpl userDao=new UserDAOImpl();
	User user = (User) session.getAttribute("CurrentUser");

	List<User>user1=userDao.history1(userId1);
	
	
	%> --%>
	
	

	<table style="width:100%">
		<tr>
			<td>USERNAME</td>
			<td>OPERATORNAME</td>
			<td>PLANID</td>
			<td>RECHARGEDATE</td>
			<td>PAYMENT</td>
			<td>MOBILENUMBER</td>
		</tr>
		<%
		while(rs.next()) {
		%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3) %></td>
			<td><%=rs.getDate(4)%></td>
			<td><%=rs.getDouble(5)%></td>
			<td><%=rs.getLong(6) %></td>
		</tr>
		<%
		}
		%>
	</table>





</body>
</html>