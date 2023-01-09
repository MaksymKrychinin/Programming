<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Market's List</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<hr>
<jsp:useBean id="marketsView" class="com.example.lab4.view.MarketsView" scope="session"></jsp:useBean>

<c:forEach var="market" items="${marketsView.markets}">
    <h2 style="text-align: center"> ${market.marketName}</h2>
    <table style="width: 100%;border: 1px">
        <c:forEach var="good" items="${market.goods}">

            <td>Name: ${good.name} Price: ${good.price}</td>

        </c:forEach>
    </table>
    <hr>
</c:forEach>
</body>
</html>
