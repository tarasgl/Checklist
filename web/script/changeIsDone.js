$(document).ready(changeIsDone);

function changeIsDone() {
    $('.change-is-done').click(function (event) {
        event.preventDefault();

        var eventId = $(event.target).parent().parent().find('input[type="hidden"]').val();
        var eventIdClass = "." + eventId;
        var name = $(eventIdClass + '.event-name').text();
        var description = $(eventIdClass + '.event-description').text();
        var isDone = ($(eventIdClass + '.is-done').text() === 'true');
        var buttonNewText = isDone ? "Mark as done" : "Mark as undone";


        $.ajax({
            url: "editEvent",
            type: "POST",
            data: {
                name: name,
                description: description,
                isDone: !isDone,
                eventID: eventId
            },
            success: function (response) {
                if (response === "success") {
                    $(eventIdClass + '.is-done').text(!isDone);
                    $(eventIdClass + '.input-is-done').prop('checked', !isDone);
                    $(eventIdClass + '.change-is-done').text(buttonNewText);
                }
            }
        });

    });
}