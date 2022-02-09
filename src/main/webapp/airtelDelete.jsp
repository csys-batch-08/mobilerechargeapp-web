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
	<c:set var="airtelId" value="${param.airtelId}" />
	<c:set var="planName" value="${param.planName}" />
	<c:set var="price" value="${param.price}" />
	<c:set var="validity" value="${param.validity}" />
	<c:set var="benefits" value="${param.benefits}" />
	<c:set var="operator" value="${param.operator}" />
	<p>PlanID:${airtelId}</p>
	<p>planName:${planName}</p>
	<p>Price:${price}</p>
	<p>validity:${validity}</p>
	<p>benefits:${benefits}</p>
	<p>operator:${operator}</p>
	<h1>Do You Want To UpdateProduct?</h1>
	<a href="DeleteairtelController?airtelId=${airtelId}"><button>
			<strong>yes</strong>
		</button></a>
	<a href="airtel.jsp"><button>no</button></a>
</body>
</html>