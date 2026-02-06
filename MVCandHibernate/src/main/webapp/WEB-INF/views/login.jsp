<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Login</h2>

<c:if test="${not empty error}">
    <div style="color:red;">${error}</div>
</c:if>

<form action="login" method="post">
    Email:
    <input type="text" name="email" required><br><br>

    Password:
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>

<a href="register">Register</a>
</body>
</html>
