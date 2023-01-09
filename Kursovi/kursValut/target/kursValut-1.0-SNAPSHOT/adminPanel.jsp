<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<c:choose>
    <c:when test="${admin==true}">
        <p>${status}</p>
        <a href="/index.jsp">Home page</a></div>
        <div class="formsRow">
            <form action="/AddCurrency" method="post">
                <label>Add currency by name</label>
                <input type="text" name="name">
                <button type="submit">Submit</button>
            </form>
            <form action="/EditCurrency" method="post">
                <label>Name of currency for edit</label>
                <input type="text" name="nameBefore">
                <br>
                <label>Name to edit</label>
                <input type="text" name="nameTo">
                <br>
                <button type="submit">Submit</button>
            </form>
            <form action="/DeleteCurrency" method="post">
                <label>Name of currency to delete</label>
                <input type="text" name="name">
                <button type="submit">Submit</button>
            </form>
            <form action="/ChangeRate" method="post">
                <label>Name of currency to set rate</label>
                <input type="text" name="name"><br>
                <label>Date To set rate</label>
                <input type="date" name="date"><br>
                <label>Set BuyRate</label>
                <input type="number" step=0.01 name="buyRate"><br>
                <label>Set SellRate</label>
                <input type="number" step=0.01 name="sellRate"><br>
                <button type="submit">Submit</button>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <a href="index.jsp">Home Page</a>
        <br>
        <a href="login.jsp">Login</a>
    </c:otherwise>
</c:choose>
</body>
</html>
