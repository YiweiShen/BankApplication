<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Bill</title>
</head>
<body>
	<form:form id="billForm" modelAttribute="bill" action="paybillProcess"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="billerName">Biller Name</form:label></td>
				<td><form:input path="billerName" name="billerName" id="billerName" /></td>
			</tr>
			<tr>
				<td><form:label path="billerAcctNo">Biller Account Number</form:label></td>
				<td><form:password path="billerAcctNo" name="billerAcctNo"
						id="billerAcctNo" /></td>
			</tr>
			<tr>
				<td><form:label path="amount">Amount</form:label></td>
				<td><form:input path="amount" name="amount"
						id="amount" /></td>
			</tr>
			<tr>
				<td><form:label path="customerId">Customer ID</form:label></td>
				<td><form:input path="customerId" name="customerId" id="customerId" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="paybill" name="paybill">Pay Bill</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="billList">Back</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>