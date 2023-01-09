<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/profile1.css" rel="stylesheet">
<c:choose>
    <c:when test="${friendsList!=null}">
        <c:forEach var="list" items="${friendsList.profileList}" >
            <div class="container">
                <a href="/ViewProfile?id=${list.id}">${list.username}</a>
                <p>${list.openInfo}</p>
                <c:if test="${list.privateInfo!=null}">
                    <p>${list.privateInfo}</p>
                </c:if>
            </div>
        </c:forEach>
        ${friendsList=null}
    </c:when>
    <c:when test="${invitesList!=null}">
        <c:forEach items="${invitesList.profileList}" var="list">
            <div class="container">
                <a href="/ViewProfile?id=${list.id}">${list.username}</a>
                <br>
                <p>${list.openInfo}</p>
                <c:if test="${list.privateInfo!=null}">
                    <br>
                    <p>${list.privateInfo}</p>
                </c:if>
                <a href="/acceptInvite?id=${list.id}">Accept</a>
            </div>
        </c:forEach>
        ${invitesList=null}
    </c:when>
    <c:when test="${searchList!=null}">
        <c:forEach items="${searchList.profileList}" var="list">
            <div class="container">
                <a href="/ViewProfile?id=${list.id}">${list.username}</a>
                <br>
                <p>${list.openInfo}</p>
                <a href="/SendInvite?id=${list.id}">Send friends request</a>
            </div>
        </c:forEach>
        ${searchList=null}
    </c:when>
</c:choose>