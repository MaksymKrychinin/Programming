<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auction</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div>
    <c:choose>
        <c:when test="${auction.idCreator==idCurrentUser}">
            <div id="settingAuction">
                <a href="index.jsp">Home Page</a>
                <form method="post" action="/startStop">
                    <label>Auction status</label>
                    <select name="startStop">
                        <option value="1">Start</option>
                        <option value="0">Stop</option>
                    </select>
                    <button type="submit">Submit</button>
                </form>
                <form method="post" action="/DeleteAuction">
                    <label>Auction delete</label>
                    <button type="submit">Submit</button>
                </form>
            </div>
            <c:if test="${auction.status==true}">
                <form method="post" action="/joinAuction">
                    <p>Count to join Auction</p>
                    <input name="countJoin" type="number">
                    <button type="submit" name="next" values="true">Join Auction</button>
                </form>
            </c:if>
            <p>Auction name : ${auction.auctionName}</p>
            <p>Creator : ${auction.creator}</p>
            <p>Status open: ${auction.status}</p>
            <div><p>Auction Users:</p>
                <div class="auctionUsers">
                <c:forEach items="${auction.list}" var="user">
                    <div class="userInAuction">
                    <p>${user.auctionSum}</p>
                    <p>${user.username}</p>
                    </div>
                </c:forEach>
                </div>
            </div>
        </c:when>
        <c:otherwise><div id="settingAuction">
            <a href="index.jsp">Home Page</a>
        </div>
            <c:if test="${auction.status==true}">
                <form method="post" action="/joinAuction">
                    <p>Count to join Auction</p>
                    <input name="countJoin" type="number">
                    <button type="submit" name="next" values="true">Join Auction</button>
                </form>
            </c:if>
            <p>Auction name : ${auction.auctionName}</p>
            <p>Creator : ${auction.creator}</p>
            <p>Auction users:</p>
            <div class="auctionUsers">
                <c:forEach items="${auction.list}" var="user">
                    <div class="userInAuction">
                    <p>${user.auctionSum}</p>
                    <p>${user.username}</p>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
