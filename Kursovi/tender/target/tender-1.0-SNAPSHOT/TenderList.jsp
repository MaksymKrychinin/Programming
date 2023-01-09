<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${tendersList!=null}">
    <div class="tenderList">
    <c:forEach var="list" items="${tendersList}">
        <div class="tenderListElements">
        <a href="/TenderOnId?id=${list.idTender}">${list.tenderName}</a>
            <p>Creator: ${list.creator}</p>
        </div>
    </c:forEach>
    </div>
    ${tendersList=null}
</c:if>
