<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style type="text/css">
*{
margin:0;
padding:0;
box-sizing: border-box;
font-family: sans-serif;
}
nav{
/* background: #222222; */
background: linear-gradient(to right, #3f56fb, #fc466b);
padding: 10px 40px 10px 70px;
border: 1px solid red;
border-left: none;
border-right: none;
}
nav ul{
display: flex;
list-style: none;
flex-wrap: wrap;
align-items: center;
justify-content: flex-end;
}
nav ul div.header{
padding:0 25px;
display: inline-flex;

}
nav ul div.header a{
text-decoration: none;
font-size: 18px;
padding:12px 28px;
font-weight: bold;
color: white;
}
nav ul div.header a:hover{
  background: white;
    color: black;

}

nav ul .search-icon{
height: 40px;
width: 240px;
display: flex;
background: #f2f2f2;
border-radius: 5px;
}
nav ul .search-icon input{
height:100%;
width: 200px;
border: none;
outline:none;
padding: 0 10px;
color:#000;
font-size:16px;
border-radius: 5px 0 0 5px;
}
nav ul .search-icon .icon{
height:100%;
width:40px;
line-height: 40px;
text-align: center;
border:1px solid #cccccc;
border-radius: 0 5px 5px 0;
}
nav ul .search-icon .icon:hover{

background:#e6e6e6;
}

nav ul .search-icon .icon span{
color:#222222;
font-size: 18px;


}
</style>

</head>
<body>

<nav>
        <ul>
        <div class="header">
        <li> <a href="Operator.jsp">Home</a></li> 
        <li> <a href="wallet.jsp">wallet</a> </li> 
        <li><a href="history.jsp">RechargeHistory</a> </li>
        <li> <a href="aboutus.jsp">AboutUs</a></li> 
        <li> <a href="contact us.jsp">ContectUs</a></li>
        <li><a href="index.jsp">Logout</a></li> 
        </div>
        <li class="search-icon">
           
            <input type="search" name="jioplan" id="plan"> 
             <label class="icon">
            <span class="fas fa-search"></span>
            </label> 
            </li>
</ul>
</nav>



</body>
</html>