<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exchange</title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
<c:choose>
<c:when test="${admin==true}">
    <p>AdminPanel</p>
    <a href="/adminPanel.jsp">Click here</a>
</c:when>
    <c:otherwise><div id="login">
        <form action="/adminLoginForm.jsp">
            <input class="myButton" type="submit" value="Login" />
        </form></div>
    </c:otherwise>
</c:choose>
<div class="ShowRate">
<form id="ShowRateOnDate" action="/ShowRateOnDate" method="post">
    <input name="name" type="text" maxlength="4">
    <input name="date1" type="date" required pattern="\d{4}-\d{2}-\d{2}">
    <input name="date2" type="date" required pattern="\d{4}-\d{2}-\d{2}">
    <br>
    <button class="myButton" type="submit">Show rate</button>
</form>
<form id="ShowRateToday" action="/ShowRateToday" method="post">
    <button class="myButton" type="submit">Show rate today</button>
</form>
</div>
<jsp:include page="table.jsp"></jsp:include>


</body>
</html>