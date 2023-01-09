<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Вхід</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;430&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap" rel="stylesheet">
    <link href="css/forms.css" rel="stylesheet">
</head>
<body>
<form id="login-form" action = "/Login" method = "POST">
    <div class="container">
        <h1>Вхід</h1>
        <p>Введін дані для входу</p>
        <hr>
        <label for="login" justify-content: center><b>Логін</b></label>
        <input type="text" placeholder="Введіть логин" name="login" required>

        <label for="password"><b>Пароль</b></label>
        <input type="password" placeholder="Введіть пароль" name="password" required>
        <hr>
        <button type="submit" class="registerbtn">Ввійти</button>
    </div>

</form>
</body>
</html>