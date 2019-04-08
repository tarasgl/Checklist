$(document).ready(function () {
    $('.delete-event').click(function (event) {
        event.preventDefault();
        var eventID = $(event.target).parent().find('input[type="hidden"]').val();

        $.ajax({
            url:"deleteEvent",
            type:"POST",
            data:{
                eventID:eventID
            },
            success: function (response) {
                if(response === "success"){
                    $('.event-container.'+eventID).remove();
                }
            }
        });
    })
})