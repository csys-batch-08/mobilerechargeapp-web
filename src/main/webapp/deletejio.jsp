<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteJioPlan</title>
</head>
<body>
<h1>Delete Plan</h1>
<form action="DeleteJioController" method="get">
<label for="jioplanid"><strong>DeletePlan</strong></label>
<input type="number" name="planId" id="jioplanid">
<br>
<input type="submit" value="DELETE">
</form>
</body>
</html>