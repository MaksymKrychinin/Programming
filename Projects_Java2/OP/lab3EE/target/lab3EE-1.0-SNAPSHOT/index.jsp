<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    double[] params = new double[12];
    String[] keys = {"aFrom", "bFrom", "cFrom", "dFrom", "aTo", "bTo", "cTo", "dTo", "aStep", "bStep", "cStep", "dStep"};
    Cookie[] cookie = request.getCookies();
    if (cookie != null) {
        for (int i = 0; i < cookie.length; i++) {
            for (int k = 0; k < keys.length; k++) {
                if (cookie[i].getName().equals(keys[k])) {
                    params[k] = Double.parseDouble(cookie[i].getValue());
                    break;
                }
            }

        }
    }

%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <title>Adcanced Calculator</title>
    <script>
        function checkIsParamValid() {
            const fromParams = document.getElementsByClassName("FromParams");
            const toParams = document.getElementsByClassName("ToParams");
            const stepParams = document.getElementsByClassName("StepParams");
            const numberOfParameters = 4;
            var n = 0;
            for (let i = 0; i < numberOfParameters; i++) {
                if (!(Math.sign(toParams[i].value - fromParams[i].value) === Math.sign(stepParams[i].value)) || fromParams[i].value >= toParams[i].value) {
                    alert("Wrong params at raw: " + (i + 1));
                    n++;
                }
            }
            if (n == 0) {
                document.getElementById('register-form').submit();
            }
        }
    </script>
</head>
<body>
<div class="table">
    <form id="register-form" action="/AdvancedCalc" method="POST">
        <div>
            <div>
                <lable>aFrom</lable>
                <input class="FromParams" type="text" name="aFrom" value="<%=params[0]%>"></div>
            <div>
                <lable>aTo</lable>
                <input class="ToParams" type="text" name="aTo" value="<%=params[4]%>"></div>
            <div>
                <lable>aStep</lable>
                <input class="StepParams" type="text" name="aStep" value="<%=params[10]%>"></div>
        </div>
        <div>
            <div>
                <lable>bFrom</lable>
                <input class="FromParams" type="text" name="bFrom" value="<%=params[1]%>"></div>
            <div>
                <lable>bTo</lable>
                <input class="ToParams" type="text" name="bTo" value="<%=params[5]%>"></div>
            <div>
                <lable>bStep</lable>
                <input class="StepParams" type="text" name="bStep" value="<%=params[9]%>">
            </div>
        </div>
        <div>
            <div>
                <lable>cFrom</lable>
                <input class="FromParams" type="text" name="cFrom" value="<%=params[2]%>"></div>
            <div>
                <lable>cTo</lable>
                <input class="ToParams" type="text" name="cTo" value="<%=params[6]%>"></div>
            <div>
                <lable>cStep</lable>
                <input class="StepParams" type="text" name="cStep" value="<%=params[10]%>"></div>
        </div>
        <div>
            <div>
                <lable>dFrom</lable>
                <input class="FromParams" type="text" name="dFrom" value="<%=params[3]%>"></div>
            <div>
                <lable>dTo</lable>
                <input class="ToParams" type="text" name="dTo" value="<%=params[7]%>"></div>
            <div>
                <lable>dStep</lable>
                <input class="StepParams" type="text" name="dStep" value="<%=params[11]%>"></div>
        </div>
    </form>
    </br>
    <button onclick="checkIsParamValid()" class="register">Обчислити</button>
</div>
<jsp:include page="table.jsp"/>
</body>

</html>