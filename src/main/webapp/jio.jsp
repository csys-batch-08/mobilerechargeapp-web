<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JioNetwork</title>

</head>


<style>
/* table, tr, td {
    text-align: left;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
}
tr:hover {background-color:threedlightshadow;}
tr:nth-child(even) {background-color: #f2f2f2;} */
table {
    background: cornflowerblue;
    padding: 10px;
}
table, tr, td {
    text-align: left;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
    text-align: center;
}
tr:nth-child(even) {
    background-color: #3f56fb;
    color: white;
    padding: 10px;5
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

</style>


</head>
<body style="text-align: center;">
<div class="header">
<a href="AdminHome.jsp">ADMIN</a>
<a href="AddJio.jsp"> JIO </a>
<a href="AddAirtel.jsp">AIRTEL</a>
<a href="AddVodafone.jsp">VODAFONE</a>
<a href="AddBsnl.jsp">BSNL</a>

<a href="index.jsp">LOGOUT</a>

</div>


<h1><strong>JIO NETWORK</strong></h1>
  
  <table style="width:100%" >
    <tr>
    <td><strong>PLANID</strong></td>
    <td><strong>PLANNAME</strong></td>
    <td><strong>PRICE</strong></td>
    <td><strong>VALIDITY</strong></td>
    <td><strong>BENEFITS</strong></td>
  	<td><strong>OPERATOR</strong></td>
 
  	
  	</tr>
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
<%}%>
</table>
  




</body>
</html>