<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>walletRecharge</title>
<style type="text/css">
.model{
text-align: center;
display: flex;
align-items: center;
}
body{
display: flex;
justify-content: center;
height:100vh;
background-image:url("images/imageswallet.jpeg");

}
label {
	font-size: 20px;
	color: black;
	margin-right: 50%;
	opacity:.8;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, .2);
}
input {
    font-size: 20px;
    width: 80%;
    margin: 2% auto;
    margin-bottom: 3%;
    border: none;
    padding: 5px;
    outline: none;
    color:black;
    border-bottom:olive;
}
form {
    width: 25rem;
    /* height: 28rem; */
    padding: 45px 0px;
    display: flex;
    flex-direction: column;
    background: rgba(255, 255, 255, 0.06);
    box-shadow: 0 8px 32px 0 rgb(31 38 135 / 37%);
    border-radius: 30px;
    border-left: 1px solid;
    border-left: 1px solid rgba(255, 255, 255, .3);
}
button {
	width: 50%;
	margin: 3% auto;
	color:white;
	font-size:15px;
	opacity:.7;
	background:rgba(255,255,255,0.06);
	padding:10px 30px;
	border:none;
	outline:none;
	border-radius:20px;
	text-shadow:2px 2px 4px rgba(255,255,255,0.2);
	box-shadow:3px 3px 5px rgba(31,38,135,.37);
	border-left:1px solid rgba(255,255,255,.3);
	border-top:1px solid rgba(255,255,255,.3)
}
.header a {
	padding: 12px 18px;
	text-decoration: none;
	font-weight: bold;
	color: white;
}

.header {
	background: linear-gradient(to right, #3f56fb, #fc466b);
	padding: 0px;
	display: flex;
	justify-content: space-around;
	position: absolute;
	top: 30px;
	width: 100%;
}

.header a:hover {
	background: white;
	color: black;
}

</style>
</head>

<body >
<% if(session.getAttribute("recharge")!=null){ 
%>
<h2> Wallet Recharged successfully</h2>
<%session.removeAttribute("recharge"); %>
<%} %>

<div class="header">
<a href="Operator.jsp">Home</a>
<a href="wallet.jsp">wallet</a>
<a href="history.jsp">RechargeHistory</a>
<a href="aboutus.jsp">AboutUs</a>
<a href="contectus.jsp">ContectUs</a>

<a href="index.jsp">Logout</a>
</div>
<div class="model">
<form action="RechargewalletController" method="get">
<h1>WALLET TOPUP</h1>
<label for="Amount" >AMOUNT:</label>
<input type="number" name="amount" id="Amount"required placeholder="Enter amount" min="0">
<button>RECHARGE</button>
<!-- <input type="submit" value="RECHARGE"> -->
</form>
</div>
</body>
</html>