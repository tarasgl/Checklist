$(document).ready(function(){
    $('#select-sort-by').change(function(event){
        event.preventDefault();
        var selectedOption = $('#select-sort-by option:selected').val();
        $.ajax({
            url: "getEvents",
            type: "GET",
            data: {
                sortBy: selectedOption
            },
            success : function (responseText) {
                $('.all-events-container').html(responseText);
                reloadButtonEvents(); // is located in addEvent.js, must be included
            }
        });
    })
});