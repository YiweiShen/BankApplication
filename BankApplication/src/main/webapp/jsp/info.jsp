<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Info</title>
</head>
<body>
	<h1>Customer Info</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>CustomerId</th>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Address</th>
			<th>State</th>
			<th>Country</th>
			<th>PostalCode</th>
			<th>Action</th>
		</tr>
		<c:forEach var="customer" items="${list}">
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.userId}</td>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.address}</td>
				<td>${customer.state}</td>
				<td>${customer.country}</td>
				<td>${customer.postalCode}</td>
				<td>
					<a href="editcustomer/${customer.customerId}">edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="accountlist">View Accounts</a>
	<br />
	<a href="billList">View Bill</a>
	<br />
	<a href="HomePage.jsp">Log Out</a>
</body>
</html>