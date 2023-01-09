<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<c:choose>
    <c:when test="${status!=null}">
        <p>${status}</p>
        ${status=null}
    </c:when>
    <c:otherwise>
        <p>Unknown error</p>
    </c:otherwise>
    </c:choose>
<a href="index.jsp">Home</a>
</body>
</html>
