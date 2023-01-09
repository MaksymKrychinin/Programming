<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p style="margin-left: 13%">
    <c:out value="${item.itemName}"/>
    <c:out value="${item.itemPrice}"/></p>

<c:forEach var="market" items="${markets.marketList}">
    <p style="margin-left: 50%">
            ${market.marketName}
            ${market.item.itemName}${market.item.itemPrice}</p>
</c:forEach>

<c:forEach var="marketList" items="${isMarketWithPriceLowerThanStock.marketList}">
    <p style="margin-left: 75%">${marketList.marketName}
            ${marketList.item.itemName}
            ${marketList.item.itemPrice}
            ${marketList.item.itemRecommendedPrice}</p>
</c:forEach>
