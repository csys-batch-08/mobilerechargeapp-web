<%@page import="com.mobilerechargeapp.exception.ErrorFound"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@page import="java.util.Date"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.*"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RechargeyourNumber</title>
<style>
.header a {
	padding: 12px 28px;
	text-decoration: none;
	font-weight: bold;
	color: white;
	text-align: center;
	padding-right: 130px;
}

.header {
	background: linear-gradient(to right, #3f56fb, #fc466b);
	display: flex;
	justify-content: space-around;
	margin-top: 0%;
	border: medium;
	position: absolute;
	top: 0px;
}

body {
	height: 100vh;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	overflow-x: hidden;
	background: linear-gradient(to right, #3f56fb, #fc466b);
}

form {
	width: 27rem;
	padding: 29px 16px;
	flex-direction: column;
	/* 	background: rgba(255, 255, 255, 0.06); */
	box-shadow: 0 8px 32px 0 rgb(31 38 135/ 37%);
	border-radius: 30px;
	border-left: 1px solid;
	border-left: 1px solid rgba(255, 255, 255, .3);
	border-left: 1px solid rgba(255, 255, 255, .3);
}

input {
	font-size: 20px;
	width: 95%;
	margin: 0px auto;
	border: none;
	outline: none;
	background: #00000030;
	color: white;
	border-bottom: 1px solid rgba(255, 255, 255, 0.6);
	margin-top: 10px;
	padding: 2px 15px;
}

label {
	font-size: 15px;
	color: white;
	text-shadow: 2px 2px 4px rgb(0 0 0/ 20%);
	text-align: left;
	margin-top: 11px;
	display: block;
}

h1 {
	text-align: center;
	font-size: 21px;
	color: white;
	text-shadow: 2px 2px 4px rgb(0 0 0/ 20%);
	letter-spacing: 3px;
	margin-bottom: 20px;
	margin-top: 10px;
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

.header a:hover {
	background: white;
	color: black;
}
</style>
</head>
<body>



	<div class="header">
		<a href="Operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
			href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
		<a href="contectus.jsp">ContectUs</a> <a href="logout.jsp">Logout</a>
	</div>
	<form action="RechargeController">
		<h1>RECHARGE YOUR NUMBER</h1>
		<label for="MobileNumber"><strong>MOBILE NUMBER</strong></label> <input
			type="text" name="mobileNumber" id="MobileNumber"
			pattern="[7-9]{1}[0-9]{9}"
			title="Phone number with 7-9 and remaing 9 digit with 0-9" required><br>

		<%
User user=(User)session.getAttribute("CurrentUser");
//	User user1=new User(user.getEmailid());	
		
	UserDAOImpl userDao=new UserDAOImpl();
	int userId=userDao.findUserId(user);
	OperatorDAOImpl operDao=new OperatorDAOImpl();
	String operator=request.getParameter("operator");
	int operatorId=operDao.findOperatorId(operator);
	String planName=request.getParameter("planName");
	/* System.out.println(planName); */
	double amount=Double.parseDouble(request.getParameter("price"));
	/* System.out.println(amount); */
	int planId;
/* 	 userId = userdao.findUserId(currentUser); */
	/* operatorId =  */
	
	try{
	 if(user.getWallet()>amount){
		
	 if (operator.equals("jio")){
	 JioDAOImpl jioDao=new JioDAOImpl();
     planId=jioDao.findjioId(planName, amount);
    /*  System.out.println(planId); */
	 }
     else if(operator.equals("Airtel")){
     AirtelDAOImpl airtelDao=new AirtelDAOImpl();
	 planId=airtelDao.findairtelId(planName, amount);
	   /* System.out.println(planId); */
     }
     else if(operator.equals("Vodafone")){
	 VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
	 planId=vodafoneDao.findvodafoneId(planName, amount);
	   /* System.out.println(planId); */
     }else {
	 BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
	 planId=bsnlDao.findbsnlId(planName, amount);
	  /*  System.out.println(planId); */
     }
	
	Date today=new Date();
   HistoryDetails hDetails=new HistoryDetails(userId,operatorId,0,planId,today,amount);
     System.out.println(userId+" "+hDetails);  
   session.setAttribute("history", hDetails);
   user.setWallet(user.getWallet()-amount);
   userDao.updateuserWallet(user);
	 }
	 else
	 {
		 throw  new ErrorFound();
	 }
	}catch(ErrorFound e)
       {
		 HttpSession session1=request.getSession();
		 session1.setAttribute("balance", e.getMessage1());
		 if(operator.equals("jio")){
		 response.sendRedirect("planjiouser.jsp");

		 }
		 else if(operator.equals("Airtel")){
		 response.sendRedirect("planairteluser.jsp"); 
		 }
		 else if(operator.equals("Vodafone")){
		response.sendRedirect("planvodafoneUser.jsp");  
		 }
		 else{
			 response.sendRedirect("planbsnluser.jsp");  
		 }
       }
	

%>


		<!-- --  <a href="RechargeController?Amount=<%=amount %>"></a>---->
		<div class="formBtn">

			<input type="submit" value="Recharge">
		</div>
	</form>
</body>
</html>