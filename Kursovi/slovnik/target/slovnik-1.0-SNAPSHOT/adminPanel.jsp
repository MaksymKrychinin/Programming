<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<c:choose>
    <c:when test="${role=='admin'}">
        <a class="button" href="index.jsp">Home page</a>
        <div class="form-container">
            <form action="/addWeather" method="post">
                <label>Location</label><br>
                <input type="text" required name="location" pattern="^[A-Z][a-z- ]{1,}"><br>
                <label>Date</label><br>
                <input type="date" required name="date" pattern="\d{4}-\d{2}-\d{2}"><br>
                <label>Weather</label><br>
                <input type="text" required name="weather"><br>
                <button type="submit">Add</button>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <jsp:include page="error.jsp"></jsp:include>
    </c:otherwise>
</c:choose>
</body>
</html>
