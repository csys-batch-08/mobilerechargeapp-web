<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>walletRecharge</title>
<link rel="stylesheet" type="text/css" href="assets/css/wallet.css"> 

</head>

<body >




<div class="header">
<a href="operator.jsp">Home</a>
<a href="wallet.jsp">wallet</a>
<a href="history.jsp">RechargeHistory</a>
<a href="aboutus.jsp">AboutUs</a>
<a href="contactus.jsp">ContectUs</a>

<a href="index.jsp">Logout</a>
</div>

 
<div class="model">
<form action="RechargewalletController" method="get">
<h1>WALLET TOPUP</h1>
<label for="Amount" >AMOUNT:</label>
<input type="number" name="amount" id="Amount"required placeholder="Enter amount" min="0">
<c:if test="${recharge!=null }">

   <h3 class=elementToFadeInAndOut > Wallet Recharged successfully</h3>
      </c:if>
       <c:remove var="recharge" scope="session" /> 
       <c:if test="${amount!=null }">
        <h3>AvailableBalance:${amount}</h3>
        </c:if>
<button>RECHARGE</button>
<!-- <input type="submit" value="RECHARGE"> -->
</form>
</div>
</body>
</html>