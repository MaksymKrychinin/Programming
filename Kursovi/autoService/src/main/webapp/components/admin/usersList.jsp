<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.12.2022
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<a href="../../index.jsp">Main Page</a>
<c:forEach items="${usersList}" var="user">
    <form action="
<c:choose>
<c:when test="${user.getBanStatus()}">
/UnbanUser
</c:when>
<c:otherwise>
/BanUser
</c:otherwise>
</c:choose>"
          method="get">
        <div style="border: #111111 3px solid">
            <p>Id User: ${user.getIduser()}</p>
            <input type="hidden" name="idUser" value="${user.getIduser()}">
            <p>Name: ${user.getName()}</p>
            <p>Surname: ${user.getSurname()}</p>
            <p>Email: ${user.getEmail()}</p>
        </div>
        <button type="submit">Change BAN status</button>
    </form>
</c:forEach>
</body>
</html>
