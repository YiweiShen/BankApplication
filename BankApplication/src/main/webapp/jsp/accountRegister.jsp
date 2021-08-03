<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply New Account</title>
</head>
<body>
	<form:form id="applyForm" modelAttribute="account" action="accountRegisterProcess"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="acctNo">Account Number</form:label></td>
				<td><form:input path="acctNo" name="acctNo" id="acctNo" /></td>
			</tr>
			<tr>
				<td><form:label path="acctType">Account Type</form:label></td>
				<td><form:password path="acctType" name="acctType"
						id="acctType" /></td>
			</tr>
			<tr>
				<td><form:label path="acctBalance">Balance</form:label></td>
				<td><form:input path="acctBalance" name="acctBalance"
						id="acctBalance" /></td>
			</tr>
			<tr>
				<td><form:label path="interestRate">Interest Rate</form:label></td>
				<td><form:input path="interestRate" name="interestRate" id="interestRate" /></td>
			</tr>
			<tr>
				<td><form:label path="customerId">Customer ID</form:label></td>
				<td><form:input path="customerId" name="customerId" id="customerId" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="accountRegister" name="accountRegister">Apply</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="accountlist">Back</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>