<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <script type="text/javascript">

    function confirmDelete(){
    	confirm("are you sure u want to delete")
    }
</script>
    <a href="home.htm">+add new Contact</a>
    
    <font color="red"> ${delmsg}</font>
    <br><br>
    <c:choose>
    <c:when test="${!empty resmsg}">
   
	<table border="1">
		<thead>
			<tr>
				<td>Contact ID</td>
				<td>Contact Name</td>
				<td>Contact Number</td>
				<td>Contact Email</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resmsg}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.contactName}</td>
					<td>${c.email}</td>
					<td>${c.phoneNo}</td>
					<td><a href="edit.htm?id=${c.id}">Edit</a> &nbsp; <a
						href="delete.htm?id=${c.id}"
						onclick="return confirmDelete()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    <br>
    <br>
    </c:when>
    <c:otherwise>Records are Not There</c:otherwise>
    
    </c:choose>
    