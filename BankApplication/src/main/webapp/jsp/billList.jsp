<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Bill List</title>
</head>
	<header> <nav>
	<ul>
		<li><a class="btn btn-warning" href="/bankApp/accountList">Account</a></li>
		<li><a class="btn btn-warning" href="/bankApp/billList">Bill</a></li>
		<li><a class="btn btn-warning" href="/bankApp/editCustomer">Profile</a></li>
		<li><a class="btn btn-warning" href="/bankApp/logout">Logout</a></li>
	</ul>
	</nav> </header>
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
	<a class="btn btn-info" href="/bankApp/payBill">Enter a bill to pay</a>
	

</body>
</html>
