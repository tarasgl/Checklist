
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
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
        <h2>Register</h2>
        <form method = "post" >
            <c:if test = "${fieldIsEmpty != null && fieldIsEmpty}">
                Fill all Fields
            </c:if>
            <c:if test = "${userAlreadyExsists != null && userAlreadyExists}">
                Username is taken
            </c:if>
            Username:<br>
            <input type="text" name="username" value=""><br>
            Password:<br>
            <input type="password" name="password" value=""><br><br>

            <c:if test = "${passwordIsConfirmed != null && !(passwordIsConfirmed)}">
                Password is not confirmed
            </c:if>
            Confirm password:<br>
            <input type="password" name="confirm-password" value=""><br><br>
            <input class ="btn  btn-primary" type="submit" value="Register">
        </form>
    </div>
    <div class = "col-lg-4 col-md-3 col-sm-2"></div>
    </div>
</body>
</html>
