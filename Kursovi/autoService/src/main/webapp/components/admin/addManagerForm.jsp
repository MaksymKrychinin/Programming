<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Manager</title>
</head>
<body>
<a href="../../index.jsp">Main Page</a>
<form action="/AddManager" method="post" style="display:flex;flex-direction: column">
    <p>Name</p>
    <input type="text" name="name">
    <p>Surname</p>
    <input type="text" name="surname">
    <p>Gender</p>
    <input type="text" name="gender">
    <p>Email</p>
    <input type="text" name="email">
    <p>Password</p>
    <input type="text" name="password">
    <p>Phone number</p>
    <input type="text" name="phoneNumber">
    <p>Date of Birthday</p>
    <input type="date" name="dateOfBirthday" min="01.01.1900" max="01.01.2004">
    <button type="submit">Add Manager</button>
</form>
</body>
</html>
