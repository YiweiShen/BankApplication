<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<header>
	<nav>
		<ul>
			<li><a href="accountList">Account</a></li>
			<li><a href="billList">Bill</a></li>
			<li><a href="editCustomer">Profile</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</nav>
</header>
<body>
	<form:form method="POST" action="/bankApp/editCustomerProcess">
		<table align="center">
			<tr>
				<td>Customer ID</td>
				<td><form:hidden path="customerId" />${customerId}</td>
			</tr>

			<tr>
				<td>User ID</td>
				<td><form:hidden path="userId" />${userId}</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><form:input path="postalCode" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update Profile" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="accountList">Back</a></td>
			</tr>
		</table>
	</form:form>

	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>