<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="adminLoginForm.css">
</head>
<body>
<div class="container">
    <div class="screen">
        <div class="screen__content">
            <form class="login" method="post" action="/isAdmin">
                <div class="login__field">
                    <i class="login__icon fas fa-user"></i>
                    <input name="login" type="text" class="login__input" placeholder="AdminLogin">
                </div>
                <div class="login__field">
                    <i class="login__icon fas fa-lock"></i>
                    <input name="password" type="password" class="login__input" placeholder="Password">
                </div>
                <button class="button login__submit">
                    <span class="button__text">Login</span>
                    <i class="button__icon fas fa-chevron-right"></i>
                </button>
            </form>
        </div>
            <div class="screen__background">
                <span class="screen__background__shape screen__background__shape4"></span>
                <span class="screen__background__shape screen__background__shape3"></span>
                <span class="screen__background__shape screen__background__shape2"></span>
                <span class="screen__background__shape screen__background__shape1"></span>
            </div>

    </div>
</div>
</body>
</html>
