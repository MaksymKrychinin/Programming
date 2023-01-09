<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Queue</title>
    <link rel="stylesheet" href="/css/stylesheet.css">
</head>
<body>
<c:choose>
    <c:when test="${idCurrentUser!=null}">
        <c:if test="${queuesList==null}">
            <c:redirect url="/actualQueue"/>
        </c:if>
        <a href="/LogOut">LogOut</a>
                <form method="post" action="/CreateQueue">
                    <label>Name of queue</label>
                    <input type="text" name="queueName">
                    <button type="submit">Create queue</button>
                </form>
                <jsp:include page="QueueList.jsp"/>
    </c:when>
    <c:otherwise>
        <div class="form-container">
            <form action="/Login" method="post">
                <label>Enter Login</label><br>
                <input name="login" required type="text"><br>
                <label>Enter password</label><br>
                <input name="password" required type="password"><br>
                <button type="submit">Login</button>
                <br>
            </form>
            <form action="/Register" id="registration" method="post">
                <label>Enter username</label><br>
                <input name="username" required type="text"><br>
                <label>Enter Login</label><br>
                <input name="login" required type="text"><br>
                <label>Enter password</label><br>
                <input name="password" required type="password"><br>
                <button type="submit">Register</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>