<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="taskList">
    <c:forEach items="${myTaskList}" var="task">
        <form class="task" action="/EditTask" method="post">
            <input type="hidden" name="id" value="${task.getId()}">
            <input class="formInput" name="name" value="${task.getName()}">
            <input style="width: 100%" class="formInput" name="description" value="${task.getDescription()}">
            <button class="button" type="submit">Edit</button>
            <a href="/DeleteTask/?id=${task.getId()}">Delete</a>
        </form>
        <hr>
    </c:forEach>
</div>
<style>
    .taskList {
        margin: 20px;
        display: flex;
        flex-direction: column;
        align-content: center;
        flex-wrap: wrap;
    }

    .task {
        width: 50%;
    }

    hr {
        color: black;
        width: 40%;
    }
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