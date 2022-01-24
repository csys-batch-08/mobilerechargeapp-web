
<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@page import="java.util.Date"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="com.mobilerechargeapp.model.Operator"%>
<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SELECTYOURNETWORK</title>
<style>
 body{
  background-image: url("images/Recbackground.jpeg");

}  
.header a {
    padding: 12px 28px;
    text-decoration: none;
    font-weight: bold;
    color: white;
}


.header {
    background: linear-gradient(to right, #3f56fb, #fc466b);
    padding: 2px;
    display: flex;
    justify-content: space-around;

}
.singleCard a {
    margin: -7px 15px;
    text-decoration: none;
}
.singleCard img {
    width: 15%;
}
.singleCard {
    width: 55%;
    display: flex;
    background:rgba(255,255,255,.3);
    justify-content: space-between;
    padding: 10px;
    align-items: center;
    box-shadow: 0px 0px 6px 0px #d7d7d7;
    margin-top: 13px;
    border-radius: 4px;
}
.header a:hover {
    background: white;
    color: black;
}
/* singleCard {
    width: 33%;
    display: flex;
    background: white;
    justify-content: space-between;
    padding: 10px;
    align-items: center;
    box-shadow: 0px 0px 6px 0px #d7d7d7;
    margin-top: 13px;
    border-radius: 4px */;
}
</style>
</head>
<body>
 <%Double Amount=(Double)session.getAttribute("amount");
 if(Amount!=null){
 %>
 <h3>AvailableBalance:<%=Amount %></h3>
 <%} %>
 <div>
<!--   <h1 style="text-align:center">SELECT YOUR NETWORK</h1> -->
  </div>
<div class="header">
<a href="Operator.jsp">Home</a>
<a href="wallet.jsp">wallet</a>
<a href="history.jsp">RechargeHistory</a>
<a href="aboutus.jsp">AboutUs</a>
<a href="ContactUs.jsp">ContactUs</a>

<a href="index.jsp">Logout</a>
</div>
<div align="center">
 
<div class="singleCard">
<a href="planjiouser.jsp"><h1>Jio</h1></a>
<img src="images/jiologo.jpg">
</div>
	<div class="singleCard">
	<a href="planairteluser.jsp"><h1>Airtel</h1></a>
	<img src="images/airtel logo.png">
	</div>
	<div class="singleCard">
	<a href="planvodafoneUser.jsp"><h1>vodafone</h1></a>
	<img src="images/VI-Logo-PNG.jpg">
	</div>
	<div class="singleCard">
	<a href="planbsnluser.jsp"><h1>Bsnl</h1></a>
	<img src="images/BSNL logo.png">
	</div>
</div>


<%User user =(User)session.getAttribute("CurrentUser");
long validity=0;


	HistorydetailsDAOImpl hisDao=new HistorydetailsDAOImpl();
	List<HistoryDetails> rechargeHistory=hisDao.findUserHistory(user);
	if(rechargeHistory.size()>0)
	{
	HistoryDetails history=rechargeHistory.get(0);
	OperatorDAOImpl operDao=new OperatorDAOImpl();
	Operator operator=operDao.findOperator(history.getOperatorId());
	Date sysDate=new Date();
	long timediff=sysDate.getTime()-history.getRechargeDate().getTime();
	long days=timediff/(1000*60*60*24)%365;
	if(operator!=null)
	{
	JioUser planJio=null;
	AirtelUser	planAirtel=null;
	VodafoneUser planVodafone=null;
	BsnlUser planBsnl=null;
	
	if(operator.getOperatorname().equals("jio"))
	{
		
		JioDAOImpl jioDao=new JioDAOImpl();
		planJio=jioDao.findPlan(history.getPlanId());
		 System.out.println(planJio);
		validity=Integer.valueOf(planJio.getValidity().split(" ")[0])-days;
		
	    System.out.println ("Days: "+validity );
		
	}
	else if(operator.getOperatorname().equals("Airtel")){
		AirtelDAOImpl airtelDao=new AirtelDAOImpl();
	planAirtel=airtelDao.findPlan(history.getPlanId());
	validity=Integer.valueOf(planAirtel.getValidity().split(" ")[0])-days;
    System.out.println ("Days: "+validity );
	}
	else if(operator.getOperatorname().equals("Vodafone")){
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		planVodafone=vodafoneDao.findPlan(history.getPlanId());
		validity=Integer.valueOf(planVodafone.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
	}
	else if(operator.getOperatorname().equals("BSNL")) {
		BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		planBsnl=bsnlDao.findPlan(history.getPlanId());
		validity=Integer.valueOf(planBsnl.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
		
	}
	
	
	
	/* if(plan!=null)
	{
	validity=Integer.valueOf(plan.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
	
	}    */
	}
	}
	

%>
<%-- <%if(validity<=10) { %> --%>
<h1><%=  validity %> days remaining validity only</h1>


</body>
</html>