<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="style.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Success!</title>
    </head>
    <body>

        <h4>Employee list</h4>

		<table cellpadding="4" cellspacing="4">
            <tr>
                <th>First Name</th>
                <th>Second Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Birth Date</th>
                <th>Action</th>
            </tr>
            
			<c:if test="${employers != null }">
	            <c:forEach var="i" begin="0" end="${size-1}">
	                <tr>
		                <td> <c:out value="${employers[i].name}"/></td>
		                <td> <c:out value="${employers[i].lastName}"/></td>
		                <td> <c:out value="${employers[i].email}"/></td>
		                <td> <c:out value="${employers[i].password}"/></td>
		                <td> <c:out value="${employers[i].birthDate}"/></td>
		                <td><input value="Edit" onClick="location.href='./edit?name=${employers[i].name}&lastName=${employers[i].lastName}&email=${employers[i].email}&birthDate=${employers[i].birthDate}'" type="button"/></td>
        	        </tr>
	            </c:forEach>
			</c:if>
        
        </table>
        
        <form action="./employeeform" method="POST">
            <input type="submit" value="Add new User"><br>
        </form>
        
    </body>
</html>