<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Pay Bill</title>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">JAM Bank</a>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/bankApp/accountList">Account</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/bankApp/billList">Bill</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/bankApp/editCustomer">Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/bankApp/logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<body>
<h1 class="m-5 text-center">Pay Bill</h1>
	<form:form method="POST" action="/bankApp/paybillProcess">
		<table align="center">
			<tr>
				<td>Customer ID</td>
				<td><form:hidden path="customerId" /><p class="text-center text-primary m-1">${customerId}</p></td>
			</tr>
			<tr>
				<td>Biller Name</td>
				<td><form:input path="billerName" class="form-control mr-sm-2 m-1" />${billerName}</td>
			</tr>
			<tr>
				<td>Biller Account No.</td>
				<td><form:input path="billerAcctNo" class="form-control mr-sm-2 m-1" />${billerAcctNo}</td>
			</tr>
			<tr>
				<td>Bill Amount</td>
				<td><form:input path="amount" class="form-control mr-sm-2 m-1" />${amount}</td>
			</tr>
			<tr>
				<td>Payment Account No.</td>
				<td><input type="text" id="paymentAcctNo" class="form-control mr-sm-2 m-1" name="paymentAcctNo"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-success mt-3 m-1" type="submit" value="Pay this bill" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a class="btn btn-secondary m-1" href="/bankApp/billList">Back</a></td>
			</tr>
		</table>
	</form:form>

	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
	<footer class="footer fixed-bottom mb-5">
	<div class="container text-center">
		<span class="text-muted">Contact Number: 123456789</span><br /> <span
			class="text-muted">Email: bob@jambank.com</span><br /> <span
			class="text-muted">Address: 5700 Yonge St, North York, ON M2M
			4K2</span>
	</div>
	</footer>
</html>