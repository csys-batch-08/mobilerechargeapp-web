<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertAirtelPlan</title>
<style>
 * {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
/* 	cursor: pointer; */
}
body {
	height: 100vh;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
/* 	background:  linear-gradient(to right, #3f56fb, #fc466b); */
background-image:url("images/Recbackground.jpeg");
}
form {
    width: 27rem;
    padding: 29px 16px;
    flex-direction: column;
    background:white;
     background:rgba(255, 255, 255, .5); 
    box-shadow: 0 8px 32px 0 rgb(31 38 135 / 37%);
    /*  border-radius: 30px; */
  /*  border-left: 1px solid;*/
     border-left: 1px solid rgba(255, 255, 255, .3); 
    border-left: 1px solid rgba(255, 255, 255, .3); 
}
h1 {
    text-align: center;
    font-size: 21px;
    color: black;
    font:bolder;
    text-shadow: 2px 2px 4px rgb(0 0 0 / 20%); 
    letter-spacing: 3px;
    margin-bottom: 2%;
    /* opacity: .6; */
    margin-top: 10px;
}
label {
    font-size: 15px;
    color:black;
  /*   opacity: .8; */
    text-shadow: 2px 2px 4px rgb(0 0 0 / 20%);
    text-align: left;
    margin-top: 11px;
    display: block;
}
input {
    font-size: 20px;
    width: 100%;
    margin: 0px auto;
     border: none;
    outline: none;
    background: #00000030; 
    color:black;
    border-bottom: 1px solid rgba(255, 255, 255, 0.6);
    margin-top: 10px;
    padding: 2px 15px;
}
.formBtn input {
    border: 1px solid;
    display: block;
    background: none;
    width: auto;
    padding: 6px 26px;
    border-radius: 3px;
    font-size: 16px;
    margin-top: 17px;
}
button{
width: 30S%;
	margin: 3% auto;
	color:black;
	font-size:15px;
	background:rgba(255,255,255,0.06);
	padding:10px 30px;

}
.header a{
    padding: 12px 28px;
    text-decoration: none;
    font-weight: bold;
    color: white;
}

.header {
    background: linear-gradient(to right, #3f56fb, #fc466b);
    padding: 0px;
    display: flex;
    justify-content: flex-end;
     position: absolute;
    top:0px;
    width: 1500px;
}
.header a:hover {
    background: white;
    color: black;
}

</style>
</head>
<body style="text-align:center;">
<div class="header">
<a href="adminHome.jsp">ADMIN</a>
<a href="addJio.jsp"> JIO </a>
<a href="addAirtel.jsp">AIRTEL</a>
<a href="addVodafone.jsp">VODAFONE</a>
<a href="addBsnl.jsp">BSNL</a>
<a href="index.jsp">LOGOUT</a>
</div>

<form action="AddairtelController" method="post">
  <h1 style="font-style: italic;">ADD PLAN </h1>
<label for="PlanName"><strong>PlanName</strong></label>
<input type="text" name="planname" id="planName"><br><br>
<label for="Price"><strong>PlanAmount</strong></label>
<input type="text" name="price"  id="Price" pattern="[0-9]+" title="invalid price,Amount should be in Positive value"><br><br>
<label for="Validity"><strong>Validity</strong></label>
<input type="text" name="validity" id="Validity"><br><br>
<label for="Benefits"><strong>Benefits</strong></label>
<input type="text" name="benefits" id="Benefits"><br><br>
<label for="Operatorname"><strong>OperatorName</strong></label> 
<input type="text" name="operatorName" id="Operatorname"  required><br><br>
<!-- <input type="submit" value="ADD"> -->
<button>INSERT</button>
	</form>
</body>
</html>