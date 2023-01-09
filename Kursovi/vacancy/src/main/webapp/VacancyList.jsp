<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${vacancyList!=null}">
  <div class="vacancyList">
    <c:forEach var="vacancy" items="${vacancyList}">
      <div class="vacancyElement">
        <p>Vacancy name: ${vacancy.vacancyName}</p>
        <p>Vacancy description: ${vacancy.description}</p>
        <p>Vacancy requirements: ${vacancy.requirements}</p>
      </div>
    </c:forEach>
  </div>
  ${vacancyList=null}
</c:if>