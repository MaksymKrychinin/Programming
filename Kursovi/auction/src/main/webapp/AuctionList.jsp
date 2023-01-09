<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${auctionsList!=null}">
    <div class="auctionList">
    <c:forEach var="list" items="${auctionsList}">
        <div class="auctionListElements">
        <a href="/AuctionOnId?id=${list.idAuction}">${list.auctionName}</a>
            <p>Creator: ${list.creator}</p>
        </div>
    </c:forEach>
    </div>
    ${auctionsList=null}
</c:if>
