<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Bill</title>
</head>
<header> <nav>
<ul>
	<li><a href="accountList">Account</a></li>
	<li><a href="billList">Bill</a></li>
	<li><a href="editCustomer">Profile</a></li>
	<li><a href="logout">Logout</a></li>
</ul>
</nav> </header>
<body>

	<form:form method="POST" action="/bankApp/paybillProcess">
		<table align="center">
			<tr>
				<td>Customer ID</td>
				<td><form:hidden path="customerId" />${customerId}</td>
			</tr>
			<tr>
				<td>Biller Name</td>
				<td><form:input path="billerName" />${billerName}</td>
			</tr>
			<tr>
				<td>Biller Account No.</td>
				<td><form:input path="billerAcctNo" />${billerAcctNo}</td>
			</tr>
			<tr>
				<td>Bill Amount</td>
				<td><form:input path="amount" />${amount}</td>
			</tr>
			<tr>
				<td>Payment Account No.</td>
				<td><input type="text" id="paymentAccount" name="paymentAccount"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Pay this bill" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="billList">Back</a></td>
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