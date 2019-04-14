$(document).ready(addEvent);

function addEvent() {

    $("#submitButton").click(function (event) {
        event.preventDefault();

        var name = $("#newEventName").val();
        var description = $("#newEventDescription").val();
        var selectedOption = $('#select-sort-by option:selected').val();
        $.ajax({
            url: "addEvent",
            type: "POST",
            data: {
                name: name,
                description: description
            },
            success: function (responseText) {
                if (responseText.valueOf() === "success") {
                    //reload all events
                    $.ajax({
                        url: "getEvents",
                        type: "GET",
                        data: {
                            sortBy: selectedOption
                        },
                        success: function (responseText) {

                            $('.all-events-container').html(responseText);
                            reloadButtonEvents();// add jquery event handlers to reloaded elements
                        }
                    })
                }
                if (responseText.valueOf() === "error") {
                    alert("object is not added!")
                }
            }
        });

    });
}

function reloadButtonEvents() {
    deleteEvent();
    editEvent();
    changeIsDone();
}
