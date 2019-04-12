$(document).ready(addEvent);

function addEvent() {

    $("#submitButton").click(function(event) {
        event.preventDefault();

        var name = $("#newEventName").val();
        var description = $("#newEventDescription").val();
        $.ajax({
            url:"addEvent",
            type:"POST",
            data:{
                name: name,
                description: description
            },
            success: function (responseText) {
                if(responseText.valueOf() === "success"){

                    $.ajax({
                        url: "getEvents",
                        type:"GET",
                        data:{

                        },
                        success: function (responseText) {

                            $('.all-events-container').html(responseText);
                            reloadButtonEvents();
                        }
                    })
                }
                if(responseText.valueOf() === "error"){
                    alert("object is not added!")
                }
            }
        });

    });
}

function reloadButtonEvents(){
    deleteEvent();
    addEvent();
    editEvent();
    changeIsDone();
}
