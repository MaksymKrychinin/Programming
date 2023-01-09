<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${scheduleList!=null}">
    <div class="scheduleList">
        <c:forEach var="schedule" items="${scheduleList}">
            <div class="doctor">
                <p>${schedule.news}</p>
                <a href="/writeInSchedule?">Check schedule</a>
            </div>
        </c:forEach>
    </div>
    ${newsList=null}
</c:if>
