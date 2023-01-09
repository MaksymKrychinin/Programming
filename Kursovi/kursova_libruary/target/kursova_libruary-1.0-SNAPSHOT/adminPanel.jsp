<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminPanel</title>
    <link href="library.css" rel="stylesheet">
</head>
<body class="bodyTop">
<a class="button" href="index.jsp">Main Page</a>
<c:choose><c:when test="${admin==true}">
    <div class="form-container">
        <form action="/addBook" method="post">
            <label>Book Name</label>
            <br>
            <input name="bookName" type="text">
            <br>
            <label>Author Name</label>
            <br>
            <input name="authorName" type="text">
            <br>
            <label>KeyWords</label>
            <br>
            <input name="keywords" type="text">
            <br>
            <button class="button" type="submit">addBook</button>
        </form>
        <form action="/deleteBook" method="post">
            <label>Book Name</label>
            <br>
            <input name="bookName" type="text">
            <br>
            <button class="button" type="submit">deleteBook</button>
        </form>
        <form action="/renameBook" method="post">
            <label>Book Name</label>
            <br>
            <input name="bookName" type="text">
            <br>
            <label>New Book Name</label>
            <br>
            <input name="newBookName" type="text">
            <br>
            <button class="button" type="submit">renameBook</button>
        </form>
    </div>
</c:when>
<c:otherwise>
    <p class="noInfo">NoData, Please login</p>
</c:otherwise>
</c:choose>
</body>
</html>
