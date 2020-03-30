<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add:city</title>
<style type="text/css">
	.error{
		color:red;
	}
</style>
</head>
<body>
	This is add page for city: add.jsp!
	<form:form action="${pageContext.request.contextPath}/cities/save" method="post" modelAttribute="cityDto">
		City number:<form:input type="text" path="number" id="numberId"/>
		<br/>
		<form:errors path="number" cssClass="error"/>
		<p/>
		City name:<form:input type="text" path="name" id="nameId"/>
		<br/>
		<form:errors path="name" cssClass="error"/>
		<p/>
		
		<button id="save">Save</button> 
	</form:form>
	
	
</body>
</html>