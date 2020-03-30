<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New User</h1>
<form:form method="post" action="${pageContext.request.contextPath}/users/save" modelAttribute="userDto">
	     User Firstname<form:input type="text" path="firstname" id="firstname"/>
		<br/>
		<form:errors path="firstname" cssClass="error"/>
		<p/>
		lastname:<form:input type="text" path="lastname" id="lastname"/>
		<br/>
		<form:errors path="lastname" cssClass="error"/>
		<p/>
		 email<form:input type="text" path="email" id="email"/>
		<br/>
		<form:errors path="email" cssClass="error"/>
		<p/>
		 password<form:input type="text" path="password" id="password"/>
		<br/>
		<form:errors path="password" cssClass="error"/>
		<p/>
		<button id="save">Save</button> 
</form:form>
