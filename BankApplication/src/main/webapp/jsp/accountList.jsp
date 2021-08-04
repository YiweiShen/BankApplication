<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Account List</title>
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
					<a class="btn btn-info" href="deposit/${account.acctNo}">Deposit</a> 
					<a class="btn btn-info" href="draw/${account.acctNo}">Draw</a>
					<a class="btn btn-info" href="transfer/${account.acctNo}">Transfer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h3>No annual fee for new accounts</h3>

	<a class="btn btn-success" href="/bankApp/newSavingAccount">Create a new Saving Account</a>
	<br />
	<a class="btn btn-success" href="/bankApp/newCheckingAccount">Create a new Checking Account</a>

</body>
</html>
