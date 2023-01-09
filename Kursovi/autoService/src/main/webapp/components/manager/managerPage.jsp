<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.12.2022
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Page</title>
</head>
<body>
<a href="/AllBillsWithStatusInRent">All Bills</a>
<form action="/ReturnCar" method="post">
    <p>Bill number for return</p>
    <input type="number" name="idBill">
    <p>Status(Accept if empty)</p>
    <input type="text" name="status">
    <button type="submit">Return Car</button>
</form>
</body>
</html>
