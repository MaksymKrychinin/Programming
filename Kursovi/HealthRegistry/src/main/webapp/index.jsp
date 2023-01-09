<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Health Registry</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<c:choose>
    <c:when test="${userId>0}">
        <c:if test="${doctorsList==null}">
            <c:redirect url="/AllDoctors"/>
        </c:if>
        <a href="/LogOut">Log Out</a>
        <div class="adminFunctions">
            <c:if test="${admin==1}">
                <form method="post" action="/NewTime">
                    <p>Create Time</p>
                    <label>Name</label><br>
                    <input type="text" required name="doctorName"><br>
                    <label>Time</label><br>
                    <input type="time" step="1" required name="time"><br>
                    <button type="submit">Create</button>
                </form>
                <form method="post" action="/EditTime">
                    <p>Edit Time</p>
                    <label>Name</label><br>
                    <input type="text" required name="doctorName"><br>
                    <label>Time to edit</label><br>
                    <input type="time" step="1" required name="time1"><br>
                    <label>New time</label><br>
                    <input type="time" step="1" required name="time2"><br>
                    <button type="submit">Edit</button>
                </form>
                <form method="post" action="/DeleteTime">
                    <p>Delete Time</p>
                    <label>Name</label><br>
                    <input type="text" required name="doctorName"><br>
                    <label>Time</label><br>
                    <input type="time" step="1" required name="time"><br>
                    <button type="submit">Delete</button>
                </form></div>
            </c:if>
        <jsp:include page="doctorsList.jsp"/>
    </c:when>
    <c:otherwise>
        <div class="login">
            <form action="/Login" method="post">
                <label>Введіть логін</label><br>
                <input name="login" required type="text"><br>
                <label>Ввудіть пароль</label><br>
                <input name="password" required type="password"><br>
                <button type="submit">Вхід</button>
                <button type="submit" formaction="/Register">Реєстрація</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>