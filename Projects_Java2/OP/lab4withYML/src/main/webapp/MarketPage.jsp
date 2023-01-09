<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:useBean id="marketView" class="com.example.lab4.view.MarketView" scope="session"></jsp:useBean>
<head>
    <title>${marketView.market.marketName}</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<hr>
<h1 style="text-align: center">${marketView.market.marketName}</h1>
<c:forEach var="good" items="${marketView.market.goods}">
    ${good.name}: ${good.price}
    <br>
</c:forEach>
<form id="register-form" action=MarketFunctionsServlet method="post">
    <input type="hidden" value="${marketView.market.marketName}" name="marketName">
    <div>
        <input type="text" name="discountPercent" value="Write discount percent">
        <input type="submit" value="DoDiscount" name="confMarket"/>
    </div>
    <div>
        <input type="text" name="goodToChangePrice" value="Write Good to Change Price">
        <input type="text" name="newPrice" value="Write New Price">
        <input type="submit" value="changePrice" name="confMarket"/>
    </div>
</form>
</body>
</html>
