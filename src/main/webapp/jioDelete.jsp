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
<c:set var="jioId" value="${param.jioId}" />
<c:set var="planName" value="${param.planName}" />
<c:set var="price" value="${param.price}"/>
<c:set var="validity" value="${param.validity}" />
<c:set var="benefits" value="${param.benefits}" />
<c:set var="operator" value="${param.operator}" />

<p>JioPlanId:${jioId}</p>
<p>productId:${planName}</p>
<p>brandName:${price}</p>
<p>brandType:${validity}</p>
<p>brandSize:${benefits}</p>
<p>color:${operator}</p>

<h1>Do You Want To UpdateProduct?</h1>
<a href="deleteplan?jioId=${jioId}"><button><strong>yes</strong></button></a>
<a href="jio.jsp"><button>no</button></a>
</body>
</html>
