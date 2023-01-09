<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <c:if test="${error!=null}">
        <p>${error}</p>
        ${error=null}
    </c:if>
<a href="index.jsp">Back</a>
</body>
</html>
