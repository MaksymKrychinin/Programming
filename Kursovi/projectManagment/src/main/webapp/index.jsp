<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project Management</title>
</head>
<body>
<div class="form-container">
    <c:choose>
        <c:when test="${user==null}">
            <form action="/SignIn" method="post" class="form">
                <input class="formInput" type="text" name="login" placeholder="Login" minlength="4">
                <input class="formInput" type="text" name="password" placeholder="Password" minlength="4">
                <button class="button">Sign in</button>
            </form>
            <form action="/SearchTask" method="post" class="form">
                <input class="formInput" type="text" name="searchText" placeholder="Search attribute" minlength="1">
                <button class="button">Search</button>
                <a class="button" href="/AllTask">Get All Tasks</a>
            </form>
        </c:when>
        <c:otherwise>
            <form action="/SearchTask" method="post" class="form">
                <input class="formInput" type="text" name="searchText" placeholder="Search attribute" minlength="1" >
                <button class="button">Search</button>
                <a class="button" href="/AllTask">Get All Tasks</a>
                <a class="button" href="/MyTasks">My Tasks</a>
            </form>
            <form action="/AddTask" method="post" class="form">
                <input class="formInput" type="text" name="taskName" placeholder="Task Name" minlength="1" >
                <input class="formInput" type="text" name="description" placeholder="Description" minlength="1" >
                <button class="button">Add Task</button>
            </form>
        </c:otherwise>
    </c:choose>
</div>
<jsp:include page="AllTask.jsp"></jsp:include>
<jsp:include page="MyTask.jsp"></jsp:include>
</body>
<style>
    html {
        height: 100%;
    }

    body {
        height: 100%;
        background-color: cornsilk;
    }

    .button {
        margin: 2px;
        font-family: 'FreeMono', monospace;
        letter-spacing: 3px;
        width: 100%;
        text-transform: uppercase;
        background-color: dimgray;
        height: 50px;
        color: #ffffff;
        font-weight: 700;
        font-size: 20px;
        cursor: pointer;
    }

    .form-container {
        width: 100%;
        text-align: -webkit-center;
        display: flex;
        height: 15%;
        justify-content: center;
    }

    .form {
        margin: 5px;
        margin-top: 3%;
        height: 20%;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    .formInput {
        margin: 5px;
    }

    .formInput:invalid {
        border: 3px solid red;
    }

    a {
        text-decoration: none;
    }
</style>
</html>