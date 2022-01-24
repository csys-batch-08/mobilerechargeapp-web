
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
<title>Insert title here</title>
<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;


}</style>
</head>
<body>
<table>
		<tr>
			<th>userId</th>
			<th>operatorId</th>
			<th>mobileNumber</th>
			<th>planId</th>
			<th>RechargeDate</th>
			<th>payment</th>
		</tr>
			<%
			
	        User user=(User)session.getAttribute("CurrentUser");
			
     HistorydetailsDAOImpl historyDao=new HistorydetailsDAOImpl();
    List<HistoryDetails>history=historyDao.findUserHis(user);
 
for(int i=0;i<history.size();i++)
{
HistoryDetails historyDetails=history.get(i);
int operatorId=historyDetails.getOperatorId();
	
%>
<tr>
<td><%= historyDetails.getUserId() %></td>
<td><%= historyDetails.getOperatorId() %></td>
<td><%= historyDetails.getMobileNumber() %></td>
<td><%= historyDetails.getPlanId() %></td>
<td><%= historyDetails.getRechargeDate() %></td>
<td><%= historyDetails.getWallet() %></td>
</tr>
<%}%>
</table>
</body>
</html>