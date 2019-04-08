$(document).ready(function(){
   $('.edit-event-container').hide();//hiding all edit forms


    $('.edit-event-button').click(function(event){
        event.preventDefault();

        var eventID = $(event.target).parent().find('input[type="hidden"]').val();
        var name = $('.edit-event-container.'+ eventID +' .input-name').val();
        var description = $('.edit-event-container.'+ eventID +' .input-description').val();
        var isDone = $('.edit-event-container.' + eventID + ' .input-is-done').prop('checked');
        var buttonNewText = (!isDone)? "Mark as done":"Mark as undone" ;

        $.ajax({
            url:"editEvent",
            type:"POST",
            data:{
                name: name,
                description: description,
                isDone: isDone,
                eventID:eventID
            },
            success: function (response) {
                if(response === "success"){
                    $('.event-container.'+eventID + ' .event-name').text(name);
                    $('.event-container.'+eventID + ' .event-description').text(description);
                    $('.event-container.'+eventID + ' .is-done').text(isDone);
                    $('.event-container.'+eventID + ' .change-is-done').text(buttonNewText)
                    $('.edit-event-container.'+ eventID).hide();
                    $('.event-container.'+ eventID).show();
                }
            }
        });
    });

    //making sertain edit form to appear
    $('.open-edit-event').click(function(event){
        event.preventDefault();
        var eventID = $(event.target).parent().find('input[type="hidden"]').val();
        $('.edit-event-container.'+ eventID).show();
        $('.event-container.'+ eventID).hide();

    });
});