<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${vacancyList!=null}">
    <div class="vacancyList">
        <c:forEach var="vacancy" items="${vacancyList}">
            <div class="vacancyElement">
                <form action="/Edit" method="post">
                    <input name="idVacancy" type="hidden" value="${vacancy.idVacancy}">
                    <label>Vacancy name</label>
                    <input name="vacancyName" type="text" value="${vacancy.vacancyName}">
                    <label>Vacancy description</label>
                    <input name="vacancyDescription" type="text" value="${vacancy.description}">
                    <label>Vacancy requirements</label>
                    <input name="vacancyRequirements" type="text" value="${vacancy.requirements}">
                    <button type="submit">Edit</button>
                    <button type="submit" formaction="/Delete">Delete</button>
                </form>
            </div>
        </c:forEach>
    </div>
    ${vacancyList=null}
</c:if>
