<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Реєстрація</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;430&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap" rel="stylesheet">
    <link href="css/forms.css" rel="stylesheet">
</head>
<body>
    <form id="register-form" action = "/Registration" method = "POST">
        <div class="container">
            <h1>Реєстрація</h1>
            <p>Введіть дані користувача</p>
            <hr>
            <label for="PIB" ><b>Введіть PIB</b></label>
            <input type="text" placeholder="П.І.Б." name="PIB" required>

            <label for="login"><b>Введіть логін</b></label>
            <input type="text" placeholder="Введіть логін" name="login" required>

            <label for="date"><b>Вкажіть дату народження</b></label>
            <input type="date" name="date" required>

            <label for="password"><b>Пароль</b></label>
            <input type="password" placeholder="Введіть пароль" name="password" required>

            <hr>
            <button type="submit" class="register">Зареєструватись</button>
        </div>
    </form>
</body>
</html>