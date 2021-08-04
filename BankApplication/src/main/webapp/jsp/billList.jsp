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
<title>Bill List</title>
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
	<h1 class="mt-5 m-3">Bill List</h1>
	<p class="m-3">This is a list of bills that you have already paid</p>
	<table class="table table-hover table-bordered m-3">
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
	<a class="btn btn-info m-3" href="/bankApp/payBill">Enter a bill to
		pay</a> </main>
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
