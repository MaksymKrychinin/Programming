<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sinoptik</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<c:choose>
    <c:when test="${logged==true}">
        <script>
            function showMore() {
                document.getElementById('oneDay').parentElement.classList.add('close');
                document.getElementById('list').parentElement.classList.remove('close');
            }

            function showLess() {
                document.getElementById('list').parentElement.classList.add('close');
                document.getElementById('oneDay').parentElement.classList.remove('close');
            }
        </script>
        <div class="allForms">
        <c:if test="${role == 'admin'}">
            <a href="adminPanel.jsp" class="button">Admin panel</a>
        </c:if>
        <a href="/SignOut" class="button">SignOut</a>
        <div class="form-container">
            <form id="oneDay" method="post" action="/weatherOneDay">
                <label>Enter Location</label><br>
                <input type="text" required name="location"><br>
                <label>Enter Date</label><br>
                <input type="date" name="date" required pattern="\d{4}-\d{2}-\d{2}"><br>
                <button type="submit">Submit</button>
            </form>
            <button onclick="showMore()">Search on list</button>
        </div>
        <div class="form-container close">
            <form id="list" method="post" action="/weatherList">
                <label>Enter Location</label><br>
                <input type="text" required name="location"><br>
                <label>Enter Date Between</label><br>
                <input type="date" name="date1" required pattern="\d{4}-\d{2}-\d{2}"><br>
                <input type="date" name="date2" required pattern="\d{4}-\d{2}-\d{2}"><br>
                <button type="submit">Submit</button>
                <br>
            </form>
            <button onclick="showLess()">Search one day</button>
        </div>
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
        </div>
    </c:otherwise>
</c:choose>
        </div>
<jsp:include page="result.jsp"></jsp:include>
</body>
</html>