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
            <div>
            <p>Translate</p>
            <form action="/AddTranslate" method="post">
                <label>language</label><br>
                <input type="text" required name="language"><br>
                <label>word</label><br>
                <input type="text" required name="word"><br>
                <label>language To Translate</label><br>
                <input type="text" required name="languageToTranslate"><br>
                <label>word Translate</label><br>
                <input type="text" required name="wordTranslate"><br>
                <button type="submit">Add</button>
            </form>
            <form action="/EditTranslate" method="post">
                <label>Word</label><br>
                <input type="text" required name="word"><br>
                <label>Word translate</label><br>
                <input type="text" required name="wordTranslate"><br>
                <label>New Word</label><br>
                <input type="text" required name="word1"><br>
                <label>New Word Translate</label><br>
                <input type="text" required name="wordTranslate1"><br>
                <button type="submit">Edit</button>
            </form>
            <form action="/DeleteTranslate" method="post">
                <label>Word</label><br>
                <input type="text" required name="word"><br>
                <label>Word translate</label><br>
                <input type="text" required name="wordTranslate"><br>
               <button type="submit">Delete</button>
            </form></div>
            <div>
            <p>Vocabulary</p>
            <form action="/AddVocabulary" method="post">
                <label>vocabularyName</label><br>
                <input type="text" required name="vocabularyName"><br>
                <label>word</label><br>
                <input type="text" required name="word"><br>
                <label>wordInfo</label><br>
                <input type="text" required name="wordInfo"><br>
                <button type="submit">Add</button>
            </form>
            <form action="/EditVocabulary" method="post">
                <label>vocabularyName</label><br>
                <input type="text" required name="vocabularyName"><br>
                <label>word</label><br>
                <input type="text" required name="word"><br>
                <label>wordInfo</label><br>
                <input type="text" required name="wordInfo"><br>
                <button type="submit">Edit</button>
            </form>
            <form action="/DeleteVocabulary" method="post">
                <label>vocabularyName</label><br>
                <input type="text" required name="vocabularyName"><br>
                <label>word</label><br>
                <input type="text" required name="word"><br>
                <button type="submit">Delete</button>
            </form>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <jsp:include page="error.jsp"></jsp:include>
    </c:otherwise>
</c:choose>
</body>
</html>
