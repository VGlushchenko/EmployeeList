<!DOCTYPE html>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style.css" media="all">
	    <title></title>
	</head>
	<body>
		<h1>Login Form</h1>
		
		<c:if test="${errors != null }">
	        <div id="error">
	            <c:forEach var="error" items="${errors}">
	                <ul>
	                    <li><c:out value="${error}"/></li>
	                </ul>
	            </c:forEach>
	        </div>
		</c:if>
		
		<form action="./employeeform" method="POST">
		    First Name<br>
		    <input type="text" name="name" value="<c:out value="${form.name}"/>"><br>
		    Last Name<br>
		    <input type="text" name="lastName" value="<c:out value="${form.lastName}"/>"><br>
		    Email<br>
		    <input type="text" name="email" value="<c:out value="${form.email}"/>"><br>
		    Password<br>
		    <input type="password" name="password" value=""><br>
		    Confirm Password<br>
		    <input type="password" name="passwordConfirmation" value=""><br>
		    Birth Date<br>
		    <input type="text" name="birthDate" value="<c:out value="${form.birthDate}" />"><br>
		    <input type="submit" value="Add"><br>
		</form>
		
		<form action="./employeeform" method="GET">
		    <input type="submit" value="View list"><br>
		</form>
		
	</body>
</html>