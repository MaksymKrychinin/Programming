<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InviteList</title>
</head>
<body><%request.getSession().setAttribute("active", 5);%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="fromListProfiles.jsp"></jsp:include>
</body>
</html>
