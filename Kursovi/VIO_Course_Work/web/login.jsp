<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jstl:if test="${not empty requestScope.notExists}">
    <p>Такого користувача не знайдено</p>
</jstl:if>

<form method="post" action="controller?action=login">
    <p><input type="text" name="name" size="10" placeholder="Login"/></p>
    <p><input type="password" name="password" size="10" placeholder="Password"/></p>
    <p><input type="submit" value="Login"/></p>
</form>
</body>
</html>
