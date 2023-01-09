<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Davinchik Home Page</title>
    <link href="css/style1.css" rel="stylesheet">
    <script>
        function showForm(elementId) {
            document.getElementById('signIn').parentElement.classList.remove('show');
            document.getElementById('register').parentElement.classList.remove('show');
            document.getElementById(elementId).parentElement.classList.add('show');
        }

        function closeForm(elementId) {
            document.getElementById(elementId).parentElement.classList.remove('show');
        }
    </script>
</head>
<body>
<%request.getSession().setAttribute("active", 1);%>
<jsp:include page="header.jsp"></jsp:include>
<div class="caption"><span>Welcome to davinchik</span></div>

<div class="hidden">
    <form action="/SignIn" method="post" class="openForm" id="signIn">
        <label>Login</label>
        <input type="text" name="login">
        <label>Password</label>
        <input type="password" name="password">
        <button type="submit">Sign In</button>
    </form>
    <a id="closeButtonSign" class="header" onclick="closeForm('signIn')">X</a>
</div>
<div class="hidden">
    <form action="/Register" method="post" class="openForm" id="register">
        <label>Username</label>
        <input type="text" name="username">
        <label>Login</label>
        <input type="text" name="login">
        <label>Password</label>
        <input type="password" name="password">
        <label>OpenInfo</label>
        <input type="text" name="openInfo">
        <label>PrivateInfo</label>
        <input type="text" name="privateInfo">
        <button type="submit">Sign In</button>
    </form>
    <a id="closeButtonReg" class="header" onclick="closeForm('register')">X</a>
</div>
<div class="bgImage" style="z-index: -1"></div>
</body>

</html>