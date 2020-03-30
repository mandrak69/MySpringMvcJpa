<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add company</title>
</head>
<body>
	This is addModeljsp for user page!
	<br /> ${command}

	<form:form action="${pageContext.request.contextPath}/users/saveModel"
		method="post" modelAttribute="userDto">
		<table>
			<tbody>
				<tr>
					<td>Firstname :</td>
					<td><form:input path="firstname" /></td>
				</tr>
				<tr>
				<tr>
					<td>Lastname</td>
					<td><form:input path="lastname" /></td>
				</tr>
				<tr>
					<td>email :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td>
						<button id="save">Save</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>