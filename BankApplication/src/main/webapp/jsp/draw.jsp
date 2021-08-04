<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Draw</title>
</head>
	<header> <nav>
	<ul>
		<li><a href="/bankApp/accountList">Account</a></li>
		<li><a href="/bankApp/billList">Bill</a></li>
		<li><a href="/bankApp/editCustomer">Profile</a></li>
		<li><a href="/bankApp/logout">Logout</a></li>
	</ul>
	</nav> </header>
<body>
	<form:form method="POST" action="/bankApp/drawProcess">
		<table align="center">
			<tr>
				<td>Draw Amount</td>
				<td><input type="text" id="drawAmount" name="drawAmount"/></td>
			</tr>
			<tr>
				<td>Customer ID</td>
				<td><form:hidden path="customerId" />${customerId}</td>
			</tr>
			<tr>
				<td>Current Balance</td>
				<td><form:hidden path="acctBalance" />${acctBalance}</td>
			</tr>
			<tr>
				<td>Account No.</td>
				<td><form:hidden path="acctNo" />${acctNo}</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Draw" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="/bankApp/accountList">Back</a></td>
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