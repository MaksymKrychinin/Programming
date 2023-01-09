<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Помилка</title>
</head>
<body>
    <c:if test="${error!=null}">
        <p>${error}</p>
        ${error=null}
    </c:if>
<a href="index.jsp">Повернутись назад</a>
</body>
</html>
