<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${doctorsList!=null}">
    <div class="doctorsList">
        <c:forEach var="doctor" items="${doctorsList}">
            <div class="doctor">
                <p>${doctor.name}</p>
                <a href="/GetDoctorById?idDoctor=${doctor.id}">Check schedule</a>
            </div>
        </c:forEach>
    </div>
    ${doctorsList=null}
</c:if>
