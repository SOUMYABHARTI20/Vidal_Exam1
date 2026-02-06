<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Students</title>
</head>
<body>
<h2>Student List</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="register">Add New Student</a>
<a href="login">Logout</a>
</body>
</html>
