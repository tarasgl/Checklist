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

<form id = "addEvent">
    <input type="text" id="newEventName" value="test">
    <input type="text" id="newEventDescription" value="test">

</form><button  id="submitButton">надіслати</button>

<div class="all-events-container">
    <c:forEach var="event" items ="${events}">

        <div class = 'row event-container <c:out value = "${event.id}"/>'>
            <input type='hidden' value ='<c:out value = "${event.id}"/>'/>
            <div class=" col-md-3">
                <span class="event-name <c:out value = "${event.id}"/>"><c:out value = "${event.name}"/></span>
            </div>
            <div class=" col-md-5 ">
                <span class="event-description <c:out value = "${event.id}"/>"><c:out value = "${event.description}"/></span>
            </div>
            <div class="col-md-1">
                <span class="is-done <c:out value = "${event.id}"/>"><c:out value="${event.isDone}" /></span>
            </div>
            <div class="col-md-1">
                <button class='change-is-done <c:out value = "${event.id}"/>' >
                    <c:if test = "${event.isDone}">Mark as undone</c:if>
                    <c:if test = "${!event.isDone}">Mark as done</c:if>
                </button>
            </div>
            <div class="col-md-1">
                <button class='delete-event <c:out value = "${event.id}"/>'>
                    Delete
                </button>
            </div>
            <div class="col-md-1">
                <button class="open-edit-event <c:out value = "${event.id}"/>"> Edit </button>
            </div>
        </div>
        <div class = 'edit-event-container row <c:out value = "${event.id}"/>'>

            <input type="hidden" value='<c:out value = "${event.id}"/>'>
            <div class=" col-md-3">
                <p>Event name </p>
                <input class="input-name <c:out value = "${event.id}"/>" type='text'
                       value='<c:out value = "${event.name}"/>'>
            </div>
            <div class=" col-md-6">
                <p> Event description</p>
                <input class="input-description <c:out value = "${event.id}"/>" type = 'text'
                       value='<c:out value = "${event.description}"/>'>
            </div>
            <div class=" col-md-1">
                <input class="input-is-done <c:out value = "${event.id}"/>" type='checkbox'
                       value='is done' <c:if test = "${event.isDone}">checked</c:if>>Is done<br>
            </div>
            <div class=" col-md-1">
                <button class='edit-event-button <c:out value = "${event.id}"/>'> edit</button>
            </div>
            <div class=" col-md-1">
                <button class="cancel-edit-event-button <c:out value = "${event.id}"/>" >Cancel</button>
            </div>
        </div>



    </c:forEach>
</div>

</body>

</html>
