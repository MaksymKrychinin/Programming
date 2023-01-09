<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="css/profile1.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <p>${profile.username}</p>
    <p>${profile.openInfo}</p>
    <p>${profile.privateInfo}</p>
</div>
</body>
</html>