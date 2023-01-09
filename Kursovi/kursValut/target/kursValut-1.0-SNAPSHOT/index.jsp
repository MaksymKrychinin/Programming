<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exchange</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="formsColumn">
    <c:choose>
        <c:when test="${admin==true}"><p><a href="/adminPanel.jsp">Admin Panel</a>
            <a href="/LogOut">LogOut</a></p>
        </c:when>
        <c:otherwise>
            <a href="login.jsp">Login</a>
        </c:otherwise>
    </c:choose>
    <form action="/TableOnDate" method="post">
        <input name="name" type="text">
        <input name="date1" type="date" required pattern="\d{4}-\d{2}-\d{2}">
        <input name="date2" type="date" required pattern="\d{4}-\d{2}-\d{2}">
        <br>
        <button type="submit">Show rate</button>
    </form>
    <form action="/TableToday" method="post">
        <button type="submit">Show rate today</button>
    </form>
</div>
<jsp:include page="table.jsp"></jsp:include>


</body>
</html>