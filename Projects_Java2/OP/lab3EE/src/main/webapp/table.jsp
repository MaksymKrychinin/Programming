<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <ul class="responsive-table">
        <li class="table-header">
            <div>a</div>
            <div>b</div>
            <div>c</div>
            <div>d</div>
            <div>result</div>
        </li>
        <c:forEach var="column" items="${table}">
            <li class="table-row">
                <c:forEach var="rows" items="${column}">
                    <div>${rows}</div>
                </c:forEach>
            </li>
        </c:forEach>
    </ul>
</div>
