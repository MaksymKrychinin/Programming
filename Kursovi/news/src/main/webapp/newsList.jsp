<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${newsList!=null}">
    <div class="newsList">
        <c:forEach var="news" items="${newsList}">
            <div class="news">
                <p>${news.news}</p>
                <p>${news.newsCatalog}</p>
                <p>${news.date}</p>
            </div>
        </c:forEach>
    </div>
    ${newsList=null}
</c:if>
