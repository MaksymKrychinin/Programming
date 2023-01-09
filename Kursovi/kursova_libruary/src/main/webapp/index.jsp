<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="library.css">
</head>
<body class="bodyTop">
    <c:choose>
        <c:when test="${admin==true}">
            <a class="button" href="/adminPanel.jsp">AdminPanel</a>
        </c:when>
        <c:otherwise>
            <a class="button" href="/adminPanelLogin.jsp">Login</a>
        </c:otherwise>
    </c:choose>
<div class="form-container">
    <form action="/SearchByAuthor" method="post">
        <label>Search by Author</label>
        <input name="searchParameter" type="text">
        <button class="button" type="submit">Search</button>
    </form>
    <form action="/SearchByName" method="post">
        <label>Search by Book Name</label>
        <input name="searchParameter" type="text">
        <button class="button" type="submit">Search</button>
    </form>
    <form action="/SearchByKeyWords" method="post">
        <label>Search by KeyWords</label>
        <input name="searchParameter" type="text">
        <button class="button" type="submit">Search</button>
    </form>
</div>
<jsp:include page="generationBooks.jsp"></jsp:include>
</body>
</html>