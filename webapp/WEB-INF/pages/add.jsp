<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add:company</title>
<style type="text/css">
	.error{
		color:red;
	}
</style>
</head>
<body>
	This is company add page!
	<form:form action="${pageContext.request.contextPath}/company/save" method="post" modelAttribute="companyDto">
		Name:<form:input type="text" path="name" id="nameId"/>
		<br/>
		<form:errors path="name" cssClass="error"/>
		<p/>
		Street:<form:input type="text" path="address" id="addressId"/>
		<br/>
		<form:errors path="address" cssClass="error"/>
		<p/>
		Street number:<form:input type="text" path="number" id="numberId"/>
		<br/>
		<form:errors path="number" cssClass="error"/>
		<p/>
		City:
		<form:select path="cityDto">
			<form:options items="${cities}" itemValue="number" itemLabel="name"/>		
		</form:select>
				
		<button id="save">Save</button> 
	</form:form>
	
	
</body>
</html>