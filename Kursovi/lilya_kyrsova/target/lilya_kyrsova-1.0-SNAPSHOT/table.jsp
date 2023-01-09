<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${tableCurrencyOfDate != null}">
    <c:choose>
    <c:when test="${tableCurrencyOfDate.length!=0}">
    <div class="container">
        <ul class="responsive-table">
            <li class="table-header">
                <div>Name</div>
                <div>Sell Rate</div>
                <div>Buy Rate</div>
                <div>Date</div>
            </li>
            <c:forEach var="rate" items="${tableCurrencyOfDate.list}">
                <li class="table-row">
                    <div>${rate.name}</div>
                    <div>${rate.sellRate}</div>
                    <div>${rate.buyRate}</div>
                    <div>${rate.date}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
    </c:when>
    <c:otherwise>
        <p>No Data</p>
    </c:otherwise>
    </c:choose>
    ${tableCurrecyOfDate=null}
</c:if>

<c:if test="${tableAllRateToday != null}">
    <c:choose>
    <c:when test="${tableCurrencyOfDate.length!=0}">
    <div class="container">
        <ul class="responsive-table">
            <li class="table-header">
                <div>Name</div>
                <div>Sell Rate</div>
                <div>Buy Rate</div>
            </li>
            <c:forEach var="rate" items="${tableAllRateToday.list}">
                <li class="table-row">
                    <div>${rate.name}</div>
                    <div>${rate.sellRate}</div>
                    <div>${rate.buyRate}</div>
                </li>
            </c:forEach>
        </ul>
    </div>
        </c:when>
    <c:otherwise>
        <p>No Data</p>
    </c:otherwise>
    </c:choose>
    ${tableAllRateToday=null}
</c:if>