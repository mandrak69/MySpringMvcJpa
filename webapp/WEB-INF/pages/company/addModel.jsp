<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add company</title>
</head>
<body>
	This is add company .jsp page!
	<br /> ${action}

	<form:form action="${pageContext.request.contextPath}/companies/save" 
							method="post" modelAttribute="companyDto">
		<table>
			<tbody>
				<tr>
					<td>Company name:</td>
					<td>
						<form:input path="name" id="name"/>
					</td>
				</tr>
				<tr>
					<td>Address:</td>
					<td>
						<form:input path="address" id="address"/>
					</td>
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
	<form action="${pageContext.request.contextPath}/Welcome" method="post">
		<table>
				<tr>
					<td>
						<button id="save">Back home</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>