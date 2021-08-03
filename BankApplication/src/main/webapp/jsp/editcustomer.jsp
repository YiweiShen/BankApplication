<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
	<form:form id="cusForm" modelAttribute="customer" action="customerRegisterProcess"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="customerId">Customer ID</form:label></td>
				<td><form:input path="customerId" name="customerId" id="customerId" /></td>
			</tr>
			<tr>
				<td><form:label path="userId">User ID</form:label></td>
				<td><form:password path="userId" name="userId"
						id="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" name="firstName"
						id="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" name="lastName" id="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" /></td>
			</tr>
			<tr>
				<td><form:label path="state">State</form:label></td>
				<td><form:input path="state" name="state" id="state" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:input path="country" name="country" id="country" /></td>
			</tr>
			<tr>
				<td><form:label path="postalCode">Postal Code</form:label></td>
				<td><form:input path="postalCode" name="postalCode" id="postalCode" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="customerRegister" name="customerRegister">Apply</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="info">Back</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>