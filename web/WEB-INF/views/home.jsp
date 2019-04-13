<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <!-- Bootstrap-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <title>Home</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="script/addEvent.js"></script>
    <script src="script/changeIsDone.js"></script>
    <script src="script/deleteEvent.js"></script>
    <script src="script/editEvent.js"></script>

    <link rel="stylesheet" href="css/styles.css">
</head>
<body>


<nav class="navbar header navbar-expand-sm ">
    <ul class="navbar-nav">
        <li class="navbar-brand">Checklist</li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/logout" />"> Logout</a>
        </li>
    </ul>
</nav>


<form id="addEvent">
    <input type="text" id="newEventName" value="test">
    <input type="text" id="newEventDescription" value="test">

</form>
<button id="submitButton">надіслати</button>

<div class="all-events-container" id="all-events-container">
    <jsp:include page="events.jsp"/>

</div>

</body>

</html>
