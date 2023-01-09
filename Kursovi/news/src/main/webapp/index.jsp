<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="css/newsStyle.css">
</head>
<body>
<c:choose>
    <c:when test="${userId>0}">
        <c:if test="${newsList==null}">
            <c:redirect url="/AllNews"/>
        </c:if>
        <a href="/LogOut">Log Out</a>
        <div class="functions">
            <c:if test="${admin==1}">

                    <form method="post" action="/CreateNews">
                        <p>Create News</p>
                        <label>News</label><br>
                        <input type="text" required name="news"><br>
                        <label>Category</label><br>
                        <input type="text" required name="category"><br>
                        <label>Date</label><br>
                        <input type="date" required name="date"><br>
                        <button type="submit">Create</button>
                    </form>
            </c:if>
                    <form method="post" action="/SearchKeywords">
                        <label>Keywords search</label><br>
                        <input type="text" required name="keywords"><br>
                        <button type="submit">Search</button>
                    </form>
                    <form method="post" action="/SearchCategory">
                        <label>Category search</label><br>
                        <input type="text" required name="category"><br>
                        <button type="submit">Search</button>
                    </form>
                </div>
        <jsp:include page="newsList.jsp"/>
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