<%@ page import="java.net.CookieHandler" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
double a=0;
double b=0;
double c=0;
double d=0;
String result = "";
Cookie [] cookie = request.getCookies();
if(cookie != null){
    for (Cookie i:cookie ) {
        if(i.getName().equals("a")){
            a = Double.parseDouble(i.getValue());
        }
        if(i.getName().equals("b")){
            b = Double.parseDouble(i.getValue());
        }
        if(i.getName().equals("c")){
            c = Double.parseDouble(i.getValue());
        }
        if(i.getName().equals("d")){
            d = Double.parseDouble(i.getValue());
        }
        if(i.getName().equals("result")){
            result = i.getValue();
        }
    }

    }%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <script>
        function addField(param){
            document.getElementById("returnResult").innerHTML = "Result = " + param;
        }
    </script>
</head>
<body onload=addField(<%=result%>)>
<form id="calculator" action = "/Calculate" method = "POST">
    <div class="container">
        <h1>Калькулятор</h1>
        <p>Введіть дані</p>
        <hr>
        <label >><b>a</b></label>
        <input type="text"  value="<%=a%>" placeholder="a" name="a" required
               pattern="^[0-9]+\.?[0-9]*$" title="write a number"><br><br>

        <label>><b>b</b></label>
        <input type="text" value="<%=b%>" placeholder="b" name="b" required
               pattern="^[0-9]+\.?[0-9]*$" title="write a number"><br><br>

        <label>><b>c</b></label>
        <input type="text"  value="<%=c%>" placeholder="c" name="c" required
               pattern="^[0-9]+\.?[0-9]*$" title="write a number"><br><br>

        <label>><b>d</b></label>
        <input type="text"  value="<%=d%>" placeholder="d" name="d" required
               pattern="^[0-9]+\.?[0-9]*$" title="write a number"><br><br>

        <hr>
        <button type="submit">Обрахувати</button>


    </div>
</form>
<p id="returnResult">Result = ...</p>
</body>
</html>