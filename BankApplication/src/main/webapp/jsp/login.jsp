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
<title>Login</title>
</head>
<body class="container bg-light d-flex flex-column"
	style="min-height: 100vh">
	<main class="flex-fill">
	<h1 align="center" class="mt-5">JAM bank</h1>
	<h3 align="center">LOGIN</h3>
	<br />
	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="userId">User Name</form:label></td>
				<td><form:input path="userId" class="form-control mr-sm-2 m-1"
						name="userId" id="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password"
						class="form-control mr-sm-2 m-1" name="password" id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button class="btn btn-primary mt-3 mb-1"
						id="login" name="login">Login</form:button></td>
			</tr>

			<tr></tr>
			<tr>
				<td></td>
				<td><a class="btn btn-secondary m-1" href="/bankApp/logout">Back</a></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

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