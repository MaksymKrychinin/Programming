<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.12.2022
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<form action="/SubmitGame" method="post">
    <div>
        <select name="winColor" style="
    font-size: 120px;
    width: 100%;
">
            <option value="red">Red</option>
            <option value="tie">Tie</option>
            <option value="blue">Blue</option>
        </select>
    </div>
    <button type="submit" style="
    font-size: 120px;
">Вибір виграшної гри</button>
</form>
</body>
</html>
