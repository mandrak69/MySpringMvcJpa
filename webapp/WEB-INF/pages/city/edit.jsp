<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Company</h1>
<form:form method="POST"
	action="${pageContext.request.contextPath}/cities/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="number" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Edit and Save" /></td>
		</tr>
	</table>
</form:form>
