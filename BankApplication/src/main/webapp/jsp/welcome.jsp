<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Welcome</title>
</head>
<body>
	<header> <nav>
	<ul>
		<li><a class="btn btn-warning" href="/bankApp/accountList">Account</a></li>
		<li><a class="btn btn-warning" href="/bankApp/billList">Bill</a></li>
		<li><a class="btn btn-warning" href="/bankApp/editCustomer">Profile</a></li>
		<li><a class="btn btn-warning" href="/bankApp/logout">Logout</a></li>
	</ul>
	</nav> </header>
	<table>
		<tr>
			<td>Welcome ${userId}!</td> 
		</tr>
		<tr>
			<td>Welcome to JAM Personal Banking</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
	</table>
	<footer>
        <table>
            <tr>
                <td>Contact Number: 123456789</td>
            </tr>
        </table>
        <table>
            <tr>
                <td>Email: bob@gmail.com</td> 
            </tr>
        </table>
        <table>
            <tr>
                <td>Address: 5700 Yonge St, North York, ON M2M 4K2</td>
            </tr>
        </table>

    </footer>
</body>
</html>
