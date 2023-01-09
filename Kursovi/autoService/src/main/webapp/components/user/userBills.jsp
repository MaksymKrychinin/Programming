<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.12.2022
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bills</title>
</head>
<body>
<a href="../../index.jsp">Main Page</a>
<div>
    <c:forEach items="${billsList}" var="bill">
        <div style="border: #111111 3px solid">
            <p>Front: <img width="300px" height="200px" src="${bill.getFrontPassport()}"></p>
            <p>Back: <img width="300px" height="200px" src="${bill.getBackPassport()}"></p>
            <p>Driver: ${bill.isDriver()}</p>
            <p>Rent time: ${bill.getRentTime()}</p>
            <p>Cost: ${bill.getCost()}</p>
            <p>Payment status: ${bill.isPaymentStatus()}</p>
            <c:if test="${!bill.isPaymentStatus()}">
                <a href="/PayForBill?idBill=${bill.getIdbill()}">Pay for bill</a>
            </c:if>
            <c:if test="${bill.isPaymentStatus()}">
                <p>${bill.getRentStatus()}</p>
                <p>${bill.getReturnStatus()}</p>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>
