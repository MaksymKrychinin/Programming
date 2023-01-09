<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="css/profile.css" rel="stylesheet">
</head>
<body><%request.getSession().setAttribute("active", 3);%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <p>${userData.username}</p>
    <p>${userData.openInfo}</p>
    <p>${userData.privateInfo}</p>
    <a href="/edit.jsp"></a>
</div>
</body>
</html>
