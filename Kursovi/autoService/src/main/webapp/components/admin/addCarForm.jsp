<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car</title>
</head>
<body>
<a href="../../index.jsp">Main Page</a>
<form action="/AddCar" method="post" style="display:flex;flex-direction: column">
    <p>Name</p>
    <input type="text" name="name" required>
    <p>Quality Class</p>
    <select name="qualityClass" required>
        <option value="S">S</option>
        <option value="A">A</option>
        <option value="B">B</option>
        <option value="C">C</option>
        <option value="D">D</option>
    </select>
    <p>Cost per Hour</p>
    <input type="number" name="costPerHour" step="any" min="0" required>
    <p>Brand</p>
    <input type="text" name="brand">
    <button type="submit">Add car</button>
</form>
</body>
</html>
