<%--
  Created by IntelliJ IDEA.
  User: Bodik
  Date: 07.05.2022
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Good page</title>
</head>
<body>
<jsp:include page="index.jsp" />
<form id="finder-form" action = FrontController method = "POST">
    <div>
        <input type="text" name="conf" value="tap good's name">
    </div>
    <button type="submit" class="register">Search</button>
</form>
</body>
</html>
