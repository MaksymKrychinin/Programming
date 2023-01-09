<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<jsp:include page="components/header.jsp"></jsp:include>
<div class="container">
    <c:if test="${user.getBanStatus()}">
        <p>YOUR ACCOUNT BANNED</p>
    </c:if>
    <p>${requestScope['javax.servlet.error.message']}</p>
    <c:if test="${requestScope['javax.servlet.error.message']==''}">
        <p>Unknown error</p>
    </c:if>

</div>
<jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>
