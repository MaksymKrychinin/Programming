
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent car</title>
</head>
<body>
<a href="../../index.jsp">Main Page</a>
<form action="/RentCar" method="post">
    <input type="hidden" name="idCar" value="${car.getIdCar()}">
    <p>Front passport url</p>
    <input type="text" name="frontPassport" required>
    <p>Back passport url</p>
    <input type="text" name="backPassport" required>
    <p>With driver</p>
    <select name="driver">
        <option value="yes" selected>Yes</option>
        <option value="no">No</option>
    </select>
    <p>Rent time</p>
    <input type="number" step="1" name="rentTime" min="1">
    <button type="submit">Rent car</button>
</form>
</body>
</html>
