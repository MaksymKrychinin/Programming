<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${table != null}">
    <c:choose>
        <c:when test="${table.length!=0}">
            <div>
                <c:forEach var="rate" items="${table.list}">
                    <div><p>Name: ${rate.name}</p>
                        <p>Sell Rate: ${rate.sellRate}</p>
                        <p>Buy Rate: ${rate.buyRate}</p>
                        <p>Date: ${rate.date}</p></div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <p>No Data</p>
        </c:otherwise>
    </c:choose>
    ${table=null}
</c:if>