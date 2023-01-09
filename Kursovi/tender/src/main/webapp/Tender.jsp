<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tender</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div>
    <c:choose>
        <c:when test="${tender.idCreator==idCurrentUser}">
            <div id="settingTender">
                <a href="index.jsp">Home Page</a>
                <form method="post" action="/startStop">
                    <label>Tender status</label>
                    <select name="startStop">
                        <option value="1">Start</option>
                        <option value="0">Stop</option>
                    </select>
                    <button type="submit">Submit</button>
                </form>
                <form method="post" action="/DeleteTender">
                    <label>Tender delete</label>
                    <button type="submit">Submit</button>
                </form>
            </div>
            <c:if test="${tender.status==true}">
                <form method="post" action="/joinTender">
                    <p>Count to join Tender</p>
                    <input name="countJoin" type="number">
                    <button type="submit" name="next" values="true">Join Tender</button>
                </form>
            </c:if>
            <p>Tender name : ${tender.tenderName}</p>
            <p>Creator : ${tender.creator}</p>
            <p>Status open: ${tender.status}</p>
            <div><p>Tender Users:</p>
                <div class="tenderUsers">
                <c:forEach items="${tender.list}" var="user">
                    <div class="userInTender">
                    <p>${user.tenderSum}</p>
                    <p>${user.username}</p>
                    </div>
                </c:forEach>
                </div>
            </div>
        </c:when>
        <c:otherwise><div id="settingTender">
            <a href="index.jsp">Home Page</a>
        </div>
            <c:if test="${tender.status==true}">
                <form method="post" action="/joinTender">
                    <p>Count to join Tender</p>
                    <input name="countJoin" type="number">
                    <button type="submit" name="next" values="true">Join Tender</button>
                </form>
            </c:if>
            <p>Tender name : ${tender.tenderName}</p>
            <p>Creator : ${tender.creator}</p>
            <p>Tender users:</p>
            <div class="tenderUsers">
                <c:forEach items="${tender.list}" var="user">
                    <div class="userInTender">
                    <p>${user.tenderSum}</p>
                    <p>${user.username}</p>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
