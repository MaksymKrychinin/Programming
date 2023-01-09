<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:useBean id="goodView" class="com.example.lab4.view.GoodView" scope="session"></jsp:useBean>
<head>
    <title>Product lower Price</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<hr>
<h1  style="text-align: center">${goodView.good.name}</h1>
<h2>Recommended price: ${goodView.good.price}</h2>
<c:forEach var="market" items="${goodView.marketPrice}">
    <h3>${market.key}</h3>
    <br>
    <h4>${goodView.good.name} cost in this market: ${market.value}</h4>
    <hr>
</c:forEach>
</body>
</html>
