<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 26.03.2019
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test = "${(badLogin!= null && badLogin == true)} ">
    <p>BadInput</p>
</c:if>
<form method = "post" >
    First name:<br>
    <input type="text" name="username" value=""><br>
    Last name:<br>
    <input type="password" name="password" value=""><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
