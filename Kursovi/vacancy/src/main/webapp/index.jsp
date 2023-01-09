<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vacancy</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<c:choose>
    <c:when test="${idUser!=null}">
        <c:choose>
            <c:when test="${userPermission==0}">
                <c:if test="${vacancyList==null}">
                    <c:redirect url="/AllVacancies"/>
                </c:if>
                <a style="position: relative" href="/LogOut">LogOut</a>
                <form method="post" action="/Search">
                    <label>Search</label>
                    <input type="text" required name="keywords">
                    <button type="submit">Search</button>
                </form>
                <jsp:include page="VacancyList.jsp"/>
            </c:when>
            <c:otherwise>
                <c:if test="${vacancyList==null}">
                    <c:redirect url="/AllVacancies"/>
                </c:if>
                <a style="position: fixed" href="/LogOut">LogOut</a>
                <div id="createVacancy">
                <form method="post" action="/CreateVacancy">
                    <label>Vacancy name</label>
                    <input type="text" required name="vacancyName">
                    <label>Vacancy description</label>
                    <input type="text" required name="vacancyDescription">
                    <label>Vacancy requirements</label>
                    <input type="text" required name="vacancyRequirements">
                    <button type="submit">Create queue</button>
                </form>
                </div>
                <jsp:include page="EmployerVacancyList.jsp"/>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <div class="form-container">
            <form action="/Login" id="login" method="post">
                <label>Enter Login</label><br>
                <input name="login" required type="text"><br>
                <label>Enter password</label><br>
                <input name="password" required type="password"><br>
                <button type="submit">Login</button>
                <br>
            </form>
            <form action="/Register" id="registration" method="post">
                <label>Enter login</label><br>
                <input name="login" required type="text"><br>
                <label>Enter password</label><br>
                <input name="password" required type="password"><br>
                <label>Choose permission</label><br>
                <select required name="permission">
                    <option value="0">Worker</option>
                    <option value="1">Employer</option>
                </select><br>
                <button type="submit">Register</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>