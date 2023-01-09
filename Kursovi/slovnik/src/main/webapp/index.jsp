<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vocabulary</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<c:choose>
<c:when test="${logged==true}">
<script>
    function showMore() {
        document.getElementById('vocabularyList').parentElement.classList.add('close');
        document.getElementById('language').parentElement.classList.remove('close');
    }

    function showLess() {
        document.getElementById('language').parentElement.classList.add('close');
        document.getElementById('vocabularyList').parentElement.classList.remove('close');
    }
</script>
<div class="allForms">
    <c:if test="${role == 'admin'}">
        <a href="adminPanel.jsp" class="button">Admin panel</a>
    </c:if>
    <a href="/SignOut" class="button">SignOut</a>
    <div class="form-container">
        <form id="vocabularyList" method="post" action="/Vocabulary">
            <label>Vocabulary Name</label><br>
            <input type="text" required name="vocabularyName"><br>
            <button type="submit">Show</button>
        </form>
        <button onclick="showMore()">Translate</button>
    </div>
    <div class="form-container close">
        <form id="language" method="post" action="/Language">
            <label>Enter language</label><br>
            <input type="text" required name="language"><br>
            <label>Enter language To translate</label><br>
            <input type="text" required name="languageToTranslate"><br>
            <label>Enter word</label><br>
            <input type="text" required name="word"><br>
            <button type="submit">Translate</button>
            <br>
        </form>
        <button onclick="showLess()">Vocabulary</button>
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