<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<jsp:include page="components/header.jsp"></jsp:include>
<c:if test="${user==null}">
    <p>Please register or Sign in</p>
</c:if>
<c:if test="${user!=null}">
<c:choose>
    <c:when test="${user.getRole()=='user' and !user.getBanStatus()}">
        <jsp:include page="components/user/userPage.jsp"></jsp:include>
    </c:when>
    <c:when test="${user.getRole()=='admin'}">
        <jsp:include page="components/admin/adminPanel.jsp"></jsp:include>
    </c:when>
    <c:when test="${user.getRole()=='manager'}">
        <jsp:include page="components/manager/managerPage.jsp"></jsp:include>
    </c:when>
    <c:when test="${user.getBanStatus()}">
        <jsp:forward page="error.jsp"></jsp:forward>
    </c:when>
    <c:otherwise></c:otherwise>
</c:choose>
</c:if>
</body>
</html>