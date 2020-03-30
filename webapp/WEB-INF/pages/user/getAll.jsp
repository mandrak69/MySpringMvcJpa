    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>User List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>email</th><th>Password</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="userDto" items="${list}"> 
    <tr>
    <td>${userDto.id}</td>
     <td>${userDto.firstname}</td>
    <td>${userDto.lastname}</td>
    <td>${userDto.email}</td>
    <td>${userDto.password}</td>
    
    <td><a href="editemp/${userDto.id}">Edit</a></td>
    <td><a href="delete/${userDto.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="add">Add New User</a>
    <br>
    <a href="addModel">Add New User as Model</a>