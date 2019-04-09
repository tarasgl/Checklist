$(document).ready(function(){
   $('.edit-event-container').hide();//hiding all edit forms


    $('.edit-event-button').click(function(event){
        event.preventDefault();

        var eventId = $(event.target).parent().parent().find('input[type="hidden"]').val();
        var eventIdClass = "." + eventId;
        var name = $( eventIdClass +'.input-name').val();
        var description = $( eventIdClass +'.input-description').val();
        var isDone = $( eventIdClass + '.input-is-done').prop('checked');
        var buttonNewText = (!isDone)? "Mark as done":"Mark as undone" ;

        $.ajax({
            url:"editEvent",
            type:"POST",
            data:{
                name: name,
                description: description,
                isDone: isDone,
                eventID:eventId
            },
            success: function (response) {
                if(response === "success"){
                    $(eventIdClass + '.event-name').text(name);
                    $(eventIdClass + '.event-description').text(description);
                    $(eventIdClass + '.is-done').text(isDone);
                    $(eventIdClass + '.change-is-done').text(buttonNewText)
                    $('.edit-event-container'+ eventIdClass).hide();
                    $('.event-container'+ eventIdClass).show();
                }
            }
        });
    });

    //making sertain edit form to appear
    $('.open-edit-event').click(function(event){
        event.preventDefault();
        var eventID = $(event.target).parent().parent().find('input[type="hidden"]').val();
        $('.edit-event-container.'+ eventID).show();
        $('.event-container.'+ eventID).hide();

    });

    //canceling editing
    $('.cancel-edit-event-button').click(function(event){
        event.preventDefault();
        var eventId = $(event.target).parent().parent().find('input[type="hidden"]').val();
        var eventIdClass ="." + eventId;
        $('.edit-event-container.'+ eventId).hide();
        $('.event-container.'+ eventId).show();
        var name = $(eventIdClass +'.input-name').val();
        var description = $(eventIdClass +'.input-description').val();
        var isDone = $(eventIdClass + '.input-is-done').prop('checked');

        $(eventIdClass +'.input-name').val(name);
        $(eventIdClass +'.input-description').val(description);
        $(eventIdClass + '.input-is-done').prop('checked', isDone);


    });
});