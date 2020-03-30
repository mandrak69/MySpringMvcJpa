    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>City list</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Number</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="cityDto" items="${list}"> 
    <tr>
    
     <td>${cityDto.name}</td>
    <td>${cityDto.number}</td>
    <td><a href="editemp/${cityDto.number}">Edit</a></td>
    <td><a href="delete/${cityDto.number}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="add">Add New city</a>
    <br>
    <a href="addModel">Add New city as Model</a>