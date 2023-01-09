<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Balance</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<c:if test="${user==null}">
    <form action="/Login" method="post" class="loginForm">
        <input type="text" name="login">
        <button type="submit">Ввійти в аккаунт</button>
    </form>
</c:if>
<c:if test="${user!=null}">
<p>Баланс: ${user.getBalance()}</p><a href="/GetBalance">Получити баланс</a>
<form action="/SubmitBet" method="post" class="submitBetForm">
    <div>
        <label for="red">Банкір ${user.getRed()}</label>
        <input id="red" name="red" type="number" max="${user.getBalance()}">
        <label for="tie">Ничія ${user.getTie()}</label>
        <input id="tie" name="tie" type="number" max="${user.getBalance()}">
        <label for="blue">Плеєр ${user.getBlue()}</label>
        <input id="blue" name="blue" type="number" max="${user.getBalance()}">
    </div>
    <button type="submit">Прийняти ставки</button>
</form>
</c:if>
</body>
</html>