<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${accountingList!=null}">
    <div class="list">
        <c:forEach var="buy" items="${accountingList}">
            <form action="/Edit" method="post">
                <input name="idBuy" type="hidden" value="${buy.idBuy}">
                <label>Назва покупки</label>
                <input name="buyName" type="text" value="${buy.buyName}">
                <label>Категорія</label>
                <input name="buyCategory" type="text" value="${buy.category}">
                <label>Дата покупки</label>
                <input name="buyDate" type="date" value="${buy.date}">
                <label>Вартість покупки</label>
                <input name="buyCost" type="number" step="0.01" value="${buy.cost}">
                <button type="submit">Редагувати</button>
                <button type="submit" formaction="/Delete">Видалити</button>
            </form>
        </c:forEach>
    </div>
    ${accountingList=null}
</c:if>
