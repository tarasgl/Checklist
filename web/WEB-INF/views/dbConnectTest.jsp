<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 24.03.2019
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var = "str" items = "${resArrayList}">
    <p><c:out value="${str}"/></p>
</c:forEach>
</body>
</html>
