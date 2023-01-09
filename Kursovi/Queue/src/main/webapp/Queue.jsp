<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Queue</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div>
    <c:choose>
        <c:when test="${queue.idCreator==idCurrentUser}">
            <div id="settingQueue">
                <a href="index.jsp">Home Page</a>
                <form method="post" action="/next">
                    <button type="submit" name="next" values="true">Next</button>
                </form>
                <form method="post" action="/openClose">
                    <label>Queue status</label>
                    <select name="openClose">
                        <option value="1">OPEN</option>
                        <option value="0">CLOSE</option>
                    </select>
                    <button type="submit">Submit</button>
                </form>
                <c:if test="${queue.status==true}">
                    <form method="post" action="/joinQueue">
                        <button type="submit" name="next" values="true">Join Queue</button>
                    </form>
                </c:if>
            </div>
            <p>Queue name : ${queue.queueName}</p>
            <p>Creator : ${queue.creator}</p>
            <p>Status: ${queue.status}</p>
            <div>Queue:
                <div class="queueUsers">
                <c:forEach items="${queue.list}" var="user">
                    <div class="userInQueue">
                    <p>${user.numberInQueue}</p>
                    <p>${user.username}</p>
                    <a href="/DeleteFromQueueById?id=${user.idUser}">Delete</a>
                    </div>
                </c:forEach>
                </div>
            </div>
        </c:when>
        <c:otherwise><div id="settingQueue">
            <a href="index.jsp">Home Page</a>
            <c:if test="${queue.status==true}">
                <form method="post" action="/joinQueue">
                    <button type="submit" name="next" values="true">Join Queue</button>
                </form>
            </c:if>
        </div>
            <p>Queue name : ${queue.queueName}</p>
            <p>Creator : ${queue.creator}</p>
            <p class="hidden" id="position">Your position is: </p>
            <p>Queue:</p>
            <div class="queueUsers">
                <c:forEach items="${queue.list}" var="user">
                    <div class="userInQueue">
                    <p>${user.numberInQueue}</p>
                    <p>${user.username}</p>
                    </div>
                    <c:if test="${user.idUser==idCurrentUser}">
                        <script>
                            function addPosition(number) {
                                document.getElementById('position').innerText += ' ' + number;
                            }

                            addPosition(${user.numberInQueue});
                        </script>
                    </c:if>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
