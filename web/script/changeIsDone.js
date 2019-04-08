$(document).ready(function(){
    $('.change-is-done').click(function(event){
        event.preventDefault();

        var eventID = $(event.target).parent().find('input[type="hidden"]').val();
        var name = $('.event-container.'+ eventID +' .event-name').text();
        var description = $('.event-container.'+ eventID +' .event-description').text();
        var isDone = ($('.event-container.'+eventID + ' .is-done').text() === 'true');
        var buttonNewText = isDone? "Mark as done":"Mark as undone" ;



        $.ajax({
            url:"editEvent",
            type:"POST",
            data:{
                name: name,
                description: description,
                isDone: !isDone,
                eventID:eventID
            },
            success: function (response) {
                if(response === "success"){
                    $('.event-container.'+eventID + ' .is-done').text(!isDone);
                    $('.edit-event-container.'+ eventID + ' .input-is-done').prop('checked', !isDone);
                    $('.event-container.'+eventID + ' .change-is-done').text(buttonNewText);
                }
            }
        });
    });
});