<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
	<form:form id="depositForm" modelAttribute="deposit" action="depositProcess"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="amount">Amount</form:label></td>
				<td><form:input path="amount" name="amount"
						id="amount" /></td>
			</tr>
			<tr>
				<td><form:label path="customerId">Customer ID</form:label></td>
				<td>${customerId}</td>
			</tr>
			<tr>
				<td><form:label path="customerId">Account No.</form:label></td>
				<td>${accountNo}</td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="deposit" name="deposit">Deposit</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="accountList">Back</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>