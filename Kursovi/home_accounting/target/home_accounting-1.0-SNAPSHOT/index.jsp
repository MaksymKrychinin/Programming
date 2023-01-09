<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accounting</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>

<c:choose>
    <c:when test="${idUser!=null and idUser!=0}">
        <a class="logout" href="/LogOut">LogOut</a>
        <div class="forms">
        <form method="post" action="/CreateBuy">
            <p>Створити покупку</p>
            <label>Назва покупки</label><br>
            <input type="text" required name="buyName"><br>
            <label>Категорія</label><br>
            <input type="text" required name="buyCategory"><br>
            <label>Дата</label><br>
            <input type="date" required name="buyDate"><br>
            <label>Вартість</label><br>
            <input type="number" step="0.01" required name="buyCost"><br>
            <button type="submit">Створити покупку</button>
        </form>
        <form method="post" action="/ViewFormDate">
            <p>Перегляд за вказаний термін</p>
            <label>Дата з</label><br>
            <input type="date" required name="date1"><br>
            <label>Дата по</label><br>
            <input type="date" required name="date2"><br>
            <button type="submit">Переглянути</button>
        </form>
        <form method="post" action="/ViewFromCategory">
            <p>Перегляд за категорією</p>
            <label>Категорія</label><br>
            <input type="text" required name="category"><br>
            <button type="submit">Переглянути</button>
        </form></div>
        <jsp:include page="accountingList.jsp"/>
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