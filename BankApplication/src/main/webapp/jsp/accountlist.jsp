<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account List</title>
</head>
<body>
	<h1>Account List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>AcctNo</th>
			<th>AcctType</th>
			<th>AcctBalance</th>
			<th>InterestRate</th>
			<th>CustomerId</th>
			<th>Action</th>
		</tr>
		<c:forEach var="account" items="${list}">
			<tr>
				<td>${account.acctNo}</td>
				<td>${account.acctType}</td>
				<td>${account.acctBalance}</td>
				<td>${account.interestRate}</td>
				<td>${account.customerId}</td>
				<td>
					<a href="deposit/${account.acctNo}">Deposit</a> 
					<a href="draw/${account.acctNo}">Draw</a>
					<a href="transfer/${account.acctNo}">Transfer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="info">Customer Info</a>
	<br />
	<a href="billList">View Bill</a>
	<br />
	<a href="accountRegister">Apply for new account</a>
	<br />
	<a href="HomePage.jsp">Log Out</a>
</body>
</html>
