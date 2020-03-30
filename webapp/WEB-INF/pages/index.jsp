<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<div>This is page: index.jsp</div>
	<c:url value="/city/add" var="cityAdd"></c:url>
	<a href="<c:out value="${cityAdd}"/>">Add city</a>

	<div>
		<c:url value="/company" var="companyHome"></c:url>
		<a href="<c:out value="${companyHome}"/>">Company home</a>
	</div>

	<div>
		<c:url value="/company/add" var="companyAdd"></c:url>
		<a href="<c:out value="${companyAdd}"/>">Company add</a>


	</div>
	<a href="cities/add">Add city</a>
	<br>
	<a href="cities/addModel">Add city as model</a>
	<br>
	<a href="cities/getAll">View All cities</a>
	<br>
	<a href="users/add">Add User</a>
	<br>
	<br>
	<br>
	<a href="users/addModel">Add User as model</a>
	<br>
	<a href="users">View All Users</a>
	<br>
	<br>
	<br>
	<a href="companies/add">Add company</a>
	<br>
	<a href="companies/addModel">Add companies as model</a>
	<br>
	<a href="companies">View All companies</a>
	<br>


</body>
</html>