<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${queuesList!=null}">
    <div class="queueList">
    <c:forEach var="list" items="${queuesList}">
        <div class="queueListElements">
        <a href="/QueueOnId?id=${list.idQueue}">${list.queueName}</a>
            <p>Creator: ${list.creator}</p>
        </div>
    </c:forEach>
    </div>
    ${queuesList=null}
</c:if>
