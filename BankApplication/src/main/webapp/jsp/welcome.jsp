<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Welcome</title>
</head>
<body class="d-flex flex-column" style="min-height: 100vh">
	<main class="flex-fill"> <nav
		class="navbar navbar-expand-lg navbar-dark bg-primary"> <a
		class="navbar-brand" href="#">JAM Bank</a>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="/bankApp/accountList">Account</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/bankApp/billList">Bill</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/bankApp/editCustomer">Profile</a></li>
			<li class="nav-item"><a class="nav-link" href="/bankApp/logout">Logout</a>
			</li>
		</ul>
	</div>
	</nav>
	<h1 class="text-warning text-center m-5">Welcome ${userId}!</h1>
	<h2 class="text-warning text-center">Welcome to use JAM Personal
		Banking.</h2>


	</main>
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
