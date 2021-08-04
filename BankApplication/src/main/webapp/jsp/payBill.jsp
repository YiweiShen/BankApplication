<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Pay Bill</title>
</head>
	<header><nav>
	<ul>
		<li><a class="btn btn-warning" href="/bankApp/accountList">Account</a></li>
		<li><a class="btn btn-warning" href="/bankApp/billList">Bill</a></li>
		<li><a class="btn btn-warning" href="/bankApp/editCustomer">Profile</a></li>
		<li><a class="btn btn-warning" href="/bankApp/logout">Logout</a></li>
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
				<td><input type="text" id="paymentAcctNo" name="paymentAcctNo"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-success" type="submit" value="Pay this bill" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a class="btn btn-secondary" href="/bankApp/billList">Back</a></td>
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