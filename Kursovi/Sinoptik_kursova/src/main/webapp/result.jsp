<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${weatherOneDay!=null}"><div class="weather">
    <p>${weatherOneDay.location.locationName} </p>
    <p>${weatherOneDay.weatherDate.date} </p>
    <p>${weatherOneDay.weather} </p>
</div>
    ${weatherOneDay=null}

</c:if>
<c:if test="${weatherList!=null}"><div class="weatherAll">
    <c:forEach items="${weatherList}" var="list">
        <div class="weather">
        <p>${list.location.locationName} </p>
        <p>${list.weatherDate.date} </p>
        <p>${list.weather} </p>
        </div>
    </c:forEach>
</div>
    ${weatherList=null}
</c:if>