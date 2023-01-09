<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.12.2022
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<div style="display: flex;flex-direction: column">
    <a href="/AllCars">All cars</a>
    <a href="/AllCarsSortedByName">All cars sorted by name</a>
    <a href="/AllCarsSortedByNameDESC">All cars sorted by name desc</a>
    <a href="/AllCarsSortedByPrice">All cars sorted by price</a>
    <a href="/AllCarsSortedByPriceDESC">All cars sorted by price desc</a>
    <form action="/CarsByBrand" method="post">
        <p>Brand</p>
        <input type="text" name="brand">
        <button type="submit">Search</button>
    </form>
    <form action="/CarsByQualityClass" method="post">
        <p>Quality class</p>
        <select name="qualityClass">
            <option value="S">S</option>
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
        </select>
        <button type="submit">Search</button>
    </form>
</div>
<div>
    <jsp:include page="carsList.jsp"></jsp:include>
</div>
</body>
</html>
