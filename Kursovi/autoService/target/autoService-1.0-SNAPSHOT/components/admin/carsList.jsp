<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.12.2022
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Editor</title>
</head>
<body>
<a href="../../index.jsp">Main Page</a>
<c:forEach items="${carsList}" var="car">
    <form action="/EditCar" method="post" style="display:flex;flex-direction: column; border: #111111 3px solid">
        <input type="hidden" name="idCar" value="${car.getIdCar()}">
        <p>Name</p>
        <input type="text" name="name" required value="${car.getName()}">
        <p>Quality Class</p>
        <select name="qualityClass" required>
            <option value="S" <c:if test="${car.getQualityClass()=='S'}">selected</c:if> >S</option>
            <option value="A" <c:if test="${car.getQualityClass()=='A'}">selected</c:if>>A</option>
            <option value="B" <c:if test="${car.getQualityClass()=='B'}">selected</c:if>>B</option>
            <option value="C" <c:if test="${car.getQualityClass()=='C'}">selected</c:if>>C</option>
            <option value="D" <c:if test="${car.getQualityClass()=='D'}">selected</c:if>>D</option>
        </select>
        <p>Cost per Hour</p>
        <input type="number" value="${car.getCostPerHour()}" name="costPerHour" step="any" min="0" required>
        <p>Brand</p>
        <input type="text" name="brand" value="${car.getBrand()}">
        <button type="submit">Edit car</button>
        <a href="/DeleteCar?idCar=${car.getIdCar()}">Delete Car</a>
    </form>
</c:forEach>

</body>
</html>
