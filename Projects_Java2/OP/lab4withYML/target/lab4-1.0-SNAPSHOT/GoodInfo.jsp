<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Good Info</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<hr>
<jsp:useBean id="goodView" class="com.example.lab4.view.GoodView" scope="session"></jsp:useBean>
<h1 style="text-align: center">${goodView.good.name}</h1>
<h2 style="text-align: center">Recommended price: ${goodView.good.price}</h2>
<h1 style="text-align: center">Market's with this product:</h1>
<c:forEach var="market" items="${goodView.marketPrice}">
    <h3>Name: ${market.key}  :  ${goodView.good.name}: price: ${market.value}</h3>

</c:forEach>
</body>
</html>
