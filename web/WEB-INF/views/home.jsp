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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="script/addEvent.js"></script>
    <script src="script/changeIsDone.js"></script>
    <script src="script/deleteEvent.js"></script>
    <script src="script/editEvent.js"></script>
</head>
<body>
<c:if test = "${user != null}">
    <h2> Hi, <c:out value ="${user}"/></h2>
</c:if>

<form id = "addEvent">
    <input type="text" id="newEventName" value="test">
    <input type="text" id="newEventDescription" value="test">

</form><button  id="submitButton">надіслати</button>

<c:forEach var="event" items ="${events}">

        <div class = 'event-container <c:out value = "${event.id}"/>'>
            <input type='hidden' value ='<c:out value = "${event.id}"/>'/>
            <h2 class="event-name"><c:out value = "${event.name}"/></h2>
            <p class="event-description"><c:out value = "${event.description}"/></p>
            <p class="is-done"><c:out value="${event.isDone}" /></p>
            <button class='change-is-done <c:out value = "${event.id}"/>' >
                <c:if test = "${event.isDone}">Mark as undone</c:if>
                <c:if test = "${!event.isDone}">Mark as done</c:if>
            </button>
            <button class='delete-event <c:out value = "${event.id}"/>'>
                Delete
            </button>
            <button class="open-edit-event <c:out value = "${event.id}"/>"> Edit </button>
        </div>
        <div class = 'edit-event-container <c:out value = "${event.id}"/>'>
            <input type="hidden" value='<c:out value = "${event.id}"/>'>
            <p >Event name </p><input class="input-name" type='text' value='<c:out value = "${event.name}"/>'>
            <p> Event description</p><input class="input-description" type = 'text' value='<c:out value = "${event.description}"/>'>
            <input class="input-is-done" type='checkbox' value='is done' <c:if test = "${event.isDone}">checked</c:if>>Is done<br>
            <button class='edit-event-button <c:out value = "${event.id}"/>'> edit</button>
            <button class="cancel-edit-event-button <c:out value = "${event.id}"/>" >Cancel</button>
        </div>



</c:forEach>

<form method="post" action="logout">
    <input type="submit" value="logout" />
</form>
</body>

</html>
