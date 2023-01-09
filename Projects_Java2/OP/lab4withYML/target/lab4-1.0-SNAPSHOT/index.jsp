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
        <div style="margin-bottom: 10px; text-align: center">See all markets</div>
        <input type="submit" value="GetMarkets" name="conf"/>
    </div>
    <div style="display: grid; width: 200px">
        <input type="text" name="goodsName" placeholder="Write Product Name" style="margin-bottom: 10px">
        <button type="submit" name="conf" value="goodsSearch" class="register">Search</button>
    </div>
    <div style="display: grid; width: 200px">
        <input type="text" name="marketName" placeholder="Write Market Name" style="margin-bottom: 10px">
        <input type="submit" value="GetMarket" name="conf"/>
    </div>
    <div style="display: grid; width: 200px">
        <input type="text" name="goodLowerPrice" placeholder="Write Product to find lower price" style="margin-bottom: 10px">
        <input type="submit" value="PriceLowest" name="conf"/>
    </div>
</form>
</body>
</html>