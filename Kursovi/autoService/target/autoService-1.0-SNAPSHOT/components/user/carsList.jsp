<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div><c:forEach var="car" items="${carsList}">
    <div style="display: flex;flex-direction: column; border: #111111 3px solid">
        <p>Name: ${car.getName()}</p>
        <p>Quality Class: ${car.getQualityClass()}</p>
        <p>Cost pe hour: ${car.getCostPerHour()}</p>
        <p>Brand: ${car.getBrand()}</p>
        <a href="/CarById?idCar=${car.getIdCar()}">Rent car</a>
    </div>
</c:forEach>
</div>
