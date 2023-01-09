<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link href="css/search1.css" rel="stylesheet">
</head>
<body><%request.getSession().setAttribute("active", 4);%>
<jsp:include page="header.jsp"></jsp:include>
<div class="search">
    <form action="SearchList" method="post">
        <input class="search" type="text" name="searchName">
        <button class="search" type="submit">SEARCH</button>
    </form>
</div>
<jsp:include page="fromListProfiles.jsp"></jsp:include>
</body>
</html>
