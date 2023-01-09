<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="taskList">
    <c:forEach items="${taskList}" var="task">
        <div class="task">
            <h2>${task.getName()}</h2>
            <p>${task.getDescription()}</p>
        </div>
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
</style>