<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link href="css/profile1.css" rel="stylesheet">
</head>
<body>
<%request.getSession().setAttribute("active", 3);%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <form action="/Edit" method="post">
        <label>Change Password</label>
        <input type="password" name="password">
        <label>Change OpenInfo</label>
        <input type="text" name="openInfo">
        <label>Change PrivateInfo</label>
        <input type="text" name="privateInfo">
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>
