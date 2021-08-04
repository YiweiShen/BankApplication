<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Account List</title>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a
	class="navbar-brand" href="#">JAM Bank</a>
<div class="collapse navbar-collapse" id="navbarText">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a class="nav-link"
			href="/bankApp/accountList">Account</a></li>
		<li class="nav-item"><a class="nav-link" href="/bankApp/billList">Bill</a>
		</li>
		<li class="nav-item"><a class="nav-link"
			href="/bankApp/editCustomer">Profile</a></li>
		<li class="nav-item"><a class="nav-link" href="/bankApp/logout">Logout</a>
		</li>
	</ul>
</div>
</nav>

<body class="d-flex flex-column" style="min-height: 100vh">
	<main class="flex-fill">
	<h1 class="mt-5 m-3">Account List</h1>
	<table class="table table-hover table-bordered m-3">
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
				<td><a class="btn btn-info" href="deposit/${account.acctNo}">Deposit</a>
					<a class="btn btn-info" href="draw/${account.acctNo}">Draw</a> <a
					class="btn btn-info" href="transfer/${account.acctNo}">Transfer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<p class="m-3">No annual fee for new accounts</p>

	<a class="btn btn-success m-2" href="/bankApp/newSavingAccount">Create
		a new Saving Account</a> <br />
	<a class="btn btn-success m-2" href="/bankApp/newCheckingAccount">Create
		a new Checking Account</a> </main>
</body>
<footer class="footer mb-5">
<div class="container text-center">
	<span class="text-muted">Contact Number: 123456789</span><br /> <span
		class="text-muted">Email: bob@jambank.com</span><br /> <span
		class="text-muted">Address: 5700 Yonge St, North York, ON M2M
		4K2</span>
</div>
</footer>
</html>
