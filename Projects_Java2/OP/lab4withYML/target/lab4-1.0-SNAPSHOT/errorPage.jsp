<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Something went wrong</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<hr>
<h1 style="text-align: center">${errorText}</h1>
</body>
</html>
