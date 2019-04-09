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
    <title>Login</title>
    <!--Bootstrap -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<c:if test = "${(badLogin!= null && badLogin == true)} ">
    <p>BadInput</p>
</c:if>

<nav class="navbar header navbar-expand-sm ">
    <ul class="navbar-nav">
        <li class="navbar-brand">Checklist</li>
        <li class="nav-item">
            <a class="nav-link" href="#"> Register</a>
        </li>
    </ul>
</nav>

<div class="row">
    <div class = "col-lg-4 col-md-3 col-sm-2"></div>
    <div class ="col-lg-4 col-md-6 col-sm-8">
        <form method = "post" >
            Username:<br>
            <input type="text" name="username" value=""><br>
            Password:<br>
            <input type="password" name="password" value=""><br><br>
            <input class ="btn  btn-primary" type="submit" value="Submit">
        </form>
    </div>
    <div class = "col-lg-4 col-md-3 col-sm-2"></div>
</div>
</body>
</html>
