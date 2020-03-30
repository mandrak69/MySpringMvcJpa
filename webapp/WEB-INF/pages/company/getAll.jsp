    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Company list</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Address</th><th>Number</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="companyDto" items="${list}"> 
    <tr>
    
     <td>${companyDto.name}</td>
    <td>${companyDto.address}</td>
    <td>${companyDto.number}</td>
    <td><a href="editemp/${companyDto.number}">Edit</a></td>
    <td><a href="delete/${companyDto.number}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="add">Add New company</a>
    <br>
    <a href="addModel">Add New company as Model</a>