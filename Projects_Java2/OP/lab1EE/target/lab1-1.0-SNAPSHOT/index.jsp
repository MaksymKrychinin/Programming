<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main Page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;430&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap" rel="stylesheet">
    <link href="css/stylesheet.css" rel="stylesheet">
    <style>
        .apple-button {
            cursor: pointer;
            width: 300px;
            height: 60px;
            text-decoration: none;
            color: #fff;
            font-size: 16px;
            text-shadow: 0 -1px 1px rgba(0, 0, 0, .3);
            background-image: -webkit-linear-gradient(#52A8E8, #377AD0);
            background-image: -moz-linear-gradient(0% 100% 90deg, #377AD0, #52A8E8);
            background-image: -o-linear-gradient(rgb(82, 168, 232), rgb(55, 122, 208));
            background-color: #52A8E8;
            -moz-border-radius: 23px;
            -webkit-border-radius: 23px;
            border-radius: 23px;
            border: 1px solid #20559A;
            box-shadow: 0 1px 2px rgba(0, 0, 0, .5), inset 0 1px 0 rgba(255, 255, 255, .3);
        }

        .apple-button:hover, .apple-button:focus {
            background-image: -webkit-linear-gradient(#54A1D8, #1967CA);
            background-image: -moz-linear-gradient(0% 100% 90deg, #1967CA, #54A1D8);
            background-image: -o-linear-gradient(rgb(84, 161, 216), rgb(25, 103, 202));
            background-color: #52A8E8;
            box-shadow: 0 1px 0 rgba(255, 255, 255, .6), inset 0 1px 0 rgba(255, 255, 255, .3);
        }

        .apple-button:active {
            background-color: #2D7CD1;
            box-shadow: 0 1px 1px rgba(255, 255, 255, .5), inset 0 2px 5px rgba(0, 0, 100, .5);
        }
    </style>
</head>
<body>
<div class="name-of-topic" style="height: 747px">
    <h1 id="name-of-topic">Сторінка входу</h1>
    <hr id="main" style="margin-bottom: 50px">
    <form method="get" action="/registration.jsp">
        <button class="apple-button">Реєстрація</button>
    </form>
    <form method="get" action="/login.jsp">
        <button class="apple-button">Вхід</button>
    </form>
    <p style="margin-top: 330px;color: white">Copyright by brigada 7</p>
</div>
</body>
</html>