<%@ page import="DB.UserCommands" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = (String) session.getAttribute("login");
    if (login == null) {
        response.sendRedirect("/sessionNotAvailable.jsp");
    }
    UserCommands userCommands = new UserCommands();
    String name = userCommands.name(login);
    String date = userCommands.date(login);

%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=name%>
    </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;430&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100&display=swap" rel="stylesheet">
    <link href="css/stylesheet.css" rel="stylesheet">
</head>
<body>
<div class="name-of-topic">
    <h1 id="name-of-topic">Резюме</h1>
    <hr id="main">
</div>
<div class="topic">
    <div id="about">
        <hr id="blocks-selector">
        <h2 id="about-me">ПРО МЕНЕ</h2>
<!--        <form method="GET" action="/Quit">
            <button type="submit">QuitFrom account</button>
        </form>-->
        <hr id="blocks-selector">
        <img id="my-photo" src="img/<%=login%>.jpg"/>
        <div id="about-info">
            <h2><%=name%>
            </h2>
            <p><br>Дата народження: <%=date%>
                <br>Зараз навчаюсь у КПІ
            </p>
        </div>
    </div>
</div>
</body>
</html>