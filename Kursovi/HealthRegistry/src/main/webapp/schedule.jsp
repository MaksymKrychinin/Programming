<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
</head>
<body>
<a href="index.jsp">Back</a>
<c:if test="${scheduleList!=null}">
    <div class="scheduleList">
        <c:forEach var="schedule" items="${scheduleList}">
            <div class="schedule">
                <p>${schedule.time}</p>
                <c:choose>
                    <c:when test="${schedule.idUser==0}">
                        <a href="/JoinSchedule?id=${schedule.id}">Join schedule</a></c:when>
                    <c:when test="${schedule.idUser==userId}">
                        <a href="/LeaveFromSchedule?id=${schedule.id}">Cancel</a></c:when>
                    <c:otherwise>
                        <p>No Slots</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>
    ${scheduleList=null}
</c:if>
</body>
</html>
