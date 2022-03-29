<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.Learning.Event.Entity.Student"%>
<html>
<head>
<style>
.myDivhead {
	border: 1px black;
	background-color: Limegreen;
	padding: 20px;
	text-align: center;
	font-size: 12px;
}

table {
	border-collapse: collapse;
	border: 0.25px solid;
	width: 100%;
}

th {
	border-collapse: collapse;
	background-color: Limegreen;
	padding: 7px;
	text-align: center;
	font-size: 17px;
	color: White;
}

tr {
	border-collapse: collapse;
	border: 0.25px black;
}

tr:nth-child(even) {
	border: 0.25px black;
	background-color: lightgray;
}

td {
	text-align: center;
}

input {
	border-radius: 5px;
	background-color: lightgray;
	border: 1px;
	font-weight: bold;
	width: 12%;
	height: 5%;
	font-size: 12px;
}
</style>
</head>

<body>
	<div class="myDivhead" id="">
		<h1>
			<b> EVENT REGISTRATION </b>
		</h1>
	</div>
	<br> <br> <br>
	<div>
		<form action="/EventRegistration/student/addForm" method="post">
			<input type="submit" name="s" value="Add Student" />
		</form>
	</div>

	<div>
		<%
			List<Student> studList = (List<Student>) request.getAttribute("allStudent");
		%>

		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
			<%
			for (Student student : studList) {
				out.println("<tr><td>" + student.getStudId() + "</td><td>" + student.getStudName() + "</td><td>"
				+ student.getStudDept() + "</td><td>" + student.getStudCountry() +
				"</td><td><a href='/EventRegistration/student/showFormUpdate?studId="
				+ student.getStudId() + "'>Update</a> | " + 
				"<a href='/EventRegistration/student/delete?studId="+ student.getStudId()
				+ "' onclick=\"return confirm('Are you sure you want to delete?')\">Delete</a></td></tr>");
			}
			%>
		</table>
	</div>
</body>
</html>