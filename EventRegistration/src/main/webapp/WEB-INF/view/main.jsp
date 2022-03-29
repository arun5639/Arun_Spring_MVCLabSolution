<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
.myDivhead {
	border: 1px black;
	background-color: Limegreen;
	padding: 20px;
	text-align: center;
	font-size: 12px;
	align:center;
}

input {
	border-radius: 5px;
	background-color: lightgray;
	border: 1px;
	font-weight: bold;
	width: 10%;
	height: 5%;
	font-size: 12px;
}
</style>
</head>
<body>
	<div class="myDivhead" id="">
		<h1><b>EVENT REGISTRATION</b></h1> <br></br><br></br>
			<form action="/EventRegistration/student/list" method="post">
				<input type="submit" name="s" value="Enter" />
			</form>
	</div>
</body>
</html>