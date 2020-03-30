<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit User</h1>
<form:form method="POST"
	action="${pageContext.request.contextPath}/users/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="id" /></td>
		</tr>
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
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:input path="password" /></td>
		</tr>





		<tr>
			<td></td>
			<td><input type="submit" value="Edit and Save" /></td>
		</tr>
	</table>
</form:form>
