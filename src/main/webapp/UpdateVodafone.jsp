<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updateVodafone</title>
<style>
 body{
 height: 100vh;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: threedlightshadow;
 }
 label{
 width:120px;
 display:inline-block;
 }
 form {
    width: 25rem;
    /* height: 28rem; */
    padding: 45px 0px;
    display: flex;
    flex-direction: column;
    background: rgba(255, 255, 255, 0.06);
    box-shadow: 0 8px 32px 0 rgb(31 38 135 / 37%);
    border-radius: 10px;
    border-left: 1px solid;
    border-left: 1px solid rgba(255, 255, 255, .3);
}
button {
	width: 50%;
	margin: 3% auto;
	color:black;
	font-size:15px;
	opacity:.7;
	background:black(255,255,255,0.06);
	padding:10px 30px;
	border:none;
	outline:none;
	border-radiurs:20px;
	text-shadow:2px 2px 4px rgba(255,255,255,0.2);
	box-shadow:3px 3px 5px rgba(31,38,135,.37);
	border-left:1px solid rgba(255,255,255,.3);
	border-top:1px solid rgba(255,255,255,.3)


</style>
</head>
<body style="text-align: center">
<form action="UpdatevodafoneController" method="get">
<h1>UPDATE PLAN</h1>
<div>
<label for="planName"><strong>PlanName</strong></label>
<input type="text" name="planname" id="planName">
</div><br><br>
<div>
<label for="Price"><strong>PlanAmount</strong></label>
<input type="text" name="price" id="Price" pattern="[0-9]+" title="invalid price,Amount should be in Positive value">
</div><br><br>
<div>
<label for="Validity"><strong>Validity</strong></label>
<input type="text" name="validity" id="Validity">
</div><br><br>
<div>
<label for="Benefits"><strong>Benefits</strong></label>
<input type="text" name="benefits" id="Benefits">
</div><br><br>
<div>
<label for="Viplanid"><strong>planId</strong></label>
<input type="number" name="ViplanId" id="Viplanid" min="0">
</div><br><br>
<button>UPDATE</button>
</form>
</body>
</html>