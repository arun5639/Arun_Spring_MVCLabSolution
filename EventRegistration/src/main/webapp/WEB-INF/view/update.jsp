<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.Learning.Event.Entity.Student"%>
<html>
<head>
<style type="text/css">

.inputcss{
	background-color: lightgrey; 
	border-radius: 5px; 
	border: 1px solid; 
	margin-left: 203px; 
	font-weight: bold; 
	width: 8%; 
	height: 5%;
}

label {
	width: 150px;
	display: inline-block;
	text-align: right;
	margin-right: 50px;
}

input {
	margin-bottom: 3px;
	border-radius: 5px; 
	border: 1px solid; 
	height: 20px
}

.myDiv {
	border: 1px black;
	background-color: Limegreen;
	padding: 10px;
	text-align: center;
	font-size: 12px;
}
</style>
<body>
	<div class="mydiv">
		<h1 style="color: white">
			<b> EVENT REGISTRATION </b>
		</h1>
	</div>

	<br>
		<div>
			<%
			Student stud = (Student) request.getAttribute("student");
			%>
			<h2 style="text-align: left; color: black; font-size: 1.25em">Save
				Customer</h2>
				
				<form action="/EventRegistration/student/update" method="post">
				
					<label for="studName">Student Name:</label> 					
					<input type="text" name="studName" value="${student.studName}" size="30" style="height:20px"/><br>										
					<label for="studDept">Student Department:</label>					
					<input type="text" name="studDept" value="${student.studDept}" size="30" style="height:20px"/><br>									
					<label for="studCountry">Student Country:</label> 					
					<input type="text" name="studCountry" value="${student.studCountry}" size="30" style="height:20px"/><br>						
					<input type="hidden" name="studId" value="${student.studId}" size="30" style="height:20px"/><br>						
										
					<input class="inputcss"	type="submit" name="submit" value="Save" />
				</form>
		</div>
			
		<form method="post">
			<a href='/EventRegistration/student/list' style="font-size:15px;">Back to List</a>
		</form>			
</body>
</html>