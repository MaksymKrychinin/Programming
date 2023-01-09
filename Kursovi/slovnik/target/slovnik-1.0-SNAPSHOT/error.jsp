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
    </c:when>
    <c:otherwise>
        <p>Smth wrong</p>
    </c:otherwise>
    </c:choose>
${status=null}
<a href="index.jsp">Click here to go Home Page</a>
</body>
</html>
