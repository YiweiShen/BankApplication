<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Draw</title>
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
<h1 class="m-5 text-center">Draw</h1>
	<form:form method="POST" action="/bankApp/drawProcess">
		<table align="center">
			<tr>
				<td>Draw Amount</td>
				<td><input type="text" class="form-control mr-sm-2" id="drawAmount" name="drawAmount"/></td>
			</tr>
			<tr>
				<td>Customer ID</td>
				<td><form:hidden path="customerId" /><p class="text-center text-primary m-1">${customerId}</p></td>
			</tr>
			<tr>
				<td>Current Balance</td>
				<td><form:hidden path="acctBalance" /><p class="text-center text-primary m-1">${acctBalance}</p></td>
			</tr>
			<tr>
				<td>Account No.</td>
				<td><form:hidden path="acctNo" /><p class="text-center text-primary m-1">${acctNo}</p></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-success mt-3 mb-1" type="submit" value="Draw" /></td>
			</tr>
			<tr>
				<td></td>
				<td><a class="btn btn-secondary m-1" href="/bankApp/accountList">Back</a></td>
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