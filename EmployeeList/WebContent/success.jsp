<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Succes</title>
</head>
<body>
<h3>User <c:out value="${form.name}"/> Has been saved</h3>

<form action="./employeeform" method="GET">
    <input type="submit" value="View list"><br>
</form>

</body>
</html>