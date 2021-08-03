<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<header> <nav>
	<ul>
		<li><a href="accountList">Account</a></li>
		<li><a href="billList">Bill</a></li>
		<li><a href="editCustomer">Profile</a></li>
		<li><a href="logout">Logout</a></li>
	</ul>
	</nav> </header>
	<table>
		<tr>
			<td>Welcome back! ${userId}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
	</table>
</body>
</html>
