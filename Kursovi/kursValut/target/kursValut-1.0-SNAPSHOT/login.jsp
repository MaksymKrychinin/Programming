<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin login panel</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="formsColumn">
    <form method="post" action="/AdminLogin">
        <input name="login" type="text" placeholder="Login">
        <input name="password" type="password" placeholder="Password">
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
