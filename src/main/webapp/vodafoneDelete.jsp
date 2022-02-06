<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="vodfoneId" value="${param.vodfoneId}" />
<c:set var="planName" value="${param.planName}" />
<c:set var="price" value="${param.price}"/>
<c:set var="validity" value="${param.validity}" />
<c:set var="benefits" value="${param.benefits}" />
<c:set var="operator" value="${param.operator}" />
<p>PlanId:${vodfoneId}</p>
<p>planName:${planName}</p>
<p>PlanAmount:${price}</p>
<p>Validity:${validity}</p>
<p>Benefits:${benefits}</p>
<p>Operator:${operator}</p>
<h1>Do You Want To Edit?</h1>
<a href="DeletevodafoneController?vodfoneId=${vodfoneId}"><button><strong>yes</strong></button></a>
<a href="vodafone.jsp"><button>no</button></a>
</body>
</html>