<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/style1.css" rel="stylesheet">
<div class="header">
    <a href="/" class="logo">Davinchik</a>
    <c:choose>
        <c:when test="${logged!=true}">
            <div class="header-right">
                <a class="active" href="/">Home</a>
                <a onclick="showForm('signIn')">Sign In</a>
                <a onclick="showForm('register')">Register</a>
            </div>
        </c:when>
        <c:otherwise> <div class="header-right">
            <a <c:if test="${active==1}">class="active"</c:if> href="/index.jsp">Home</a>
            <a <c:if test="${active==2}">class="active"</c:if>  href="/FriendsList">Friends</a>
            <a <c:if test="${active==3}">class="active"</c:if> href="/profile.jsp">Profile</a>
            <a <c:if test="${active==4}">class="active"</c:if> href="/search.jsp">Search</a>
            <a <c:if test="${active==5}">class="active"</c:if> href="/InvitesList">Invites</a>
            <a href="/SignOut">SignOut</a>
        </div>

        </c:otherwise>
    </c:choose>
</div>