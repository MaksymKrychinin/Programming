<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1 style="text-align: center">What to do?</h1>
<br/>
<form id="register-form" action=FrontController method="post" style="display: flex; justify-content: space-around">
    <div style="display: grid; width: 200px">
        <input type="text" name="first" placeholder="Write Product Name For Min Price"
               style="margin-bottom: 10px">
        <button type="submit" name="conf" value="minimumPriceFromName" class="register">minimum price from name</button>
    </div>
    <div style="display: grid; width: 200px">
        <input type="text" name="second"
               placeholder="Write item Name To Get list of markets, where price is minimum" style="margin-bottom: 10px"/>
        <input type="submit" value="listOfMarketsWhereItemPriceIsMinimum" name="conf"/>
    </div>
    <div style="display: grid; width: 200px">
        <p type="text" name="third"
           placeholder="Name Of Market/s where all prices is less than recommended price" style="margin-bottom: 10px">
            <input type="submit" value="theCheapestShop" name="conf"/>
    </div>
</form>
<jsp:include page="output.jsp" />
</body>
</html>