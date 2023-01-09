<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminPanel</title>
    <link rel="stylesheet" type="text/css" href="adminPanel.css">
</head>
<body>
<c:choose>
    <c:when test="${admin==true}">
        <p class="status">${status}</p>
        <div id="homePageButton">
            <a class="myButton" href="/index.jsp">Home page</a></div>
        <div style="overflow: hidden;">
        <div style="width: 500%;">
            <div class="formsAdmin">
                <form action="/addNewCurrency" method="post">
                    <label>Add currency by name</label>
                    <input type="text" name="addForName">
                    <button type="submit">Submit</button>
                </form>
            </div>
            <div class="formsAdmin">
                <form action="/editCurrency" method="post">
                    <label>Name of currency for edit</label>
                    <input type="text" name="nameOfCurrencyForEdit">
                    <br>
                    <label>Name after edit</label>
                    <input type="text" name="nameAfterEdit">
                    <br>
                    <button type="submit">Submit</button>
                </form>
            </div>
            <div class="formsAdmin">
                <form action="/deleteCurrency" method="post">
                    <label>Name of currency to delete</label>
                    <input type="text" name="nameOfCurrencyDelete">
                    <button type="submit">Submit</button>
                </form></div>
            <div class="formsAdmin">
                <form action="/changeRate" method="post">
                    <label>Name of currency to set rate</label>
                    <input type="text" name="nameOfCurrencyToSetDate"><br>
                    <label>Date To set rate</label>
                    <input type="date" name="dateToSetRate"><br>
                    <label>Set BuyRate</label>
                    <input type="number" step=0.01 name="buyRateToSet"><br>
                    <label>Set SellRate</label>
                    <input type="number" step=0.01 name="sellRateToSet"><br>
                    <button type="submit">Submit</button>
                </form>
            </div></div>
        </div>
    </c:when>
    <c:otherwise>
        <p>No Perremisions/pls login</p>
        <a href="adminLoginForm.jsp">Click here</a>
    </c:otherwise>
</c:choose>
</body>
</html>
