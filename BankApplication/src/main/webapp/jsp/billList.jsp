<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill List</title>
</head>
<body>
	<h1>Bill List</h1>
	<p>This is a list of bills that you have already paid</p>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>BillerName</th>
			<th>BillerAcctNo</th>
			<th>Amount</th>
			<th>CustomerId</th>
		</tr>
		<c:forEach var="bill" items="${list}">
			<tr>
				<td>${bill.billerName}</td>
				<td>${bill.billerAcctNo}</td>
				<td>${bill.amount}</td>
				<td>${bill.customerId}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="payBill">Add Bill</a>
	<br>
	<a href="accountList">View Accounts</a>
	<br>
	<a href="info">Customer Info</a>
	<br>
	<a href="logout">Log Out</a>
</body>
</html>
