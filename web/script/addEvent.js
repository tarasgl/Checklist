$(document).ready(function(){

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
                    alert("object added!")
                }
                if(responseText.valueOf() === "error"){
                    alert("object is not added!")
                }
            }
        })
        /*
        $.post('addEvent/',
            {
                name: $('newEventName').val(),
                description: $('newEventDescription').val()
            },
            function (responseText) {
                if(responseText.valueOf() == "succeess"){
                    alert("object added!")
                }
                if(responseText.valueOf() == "error"){
                    alert("object is not added!")
                }
            }
        )*/
    })
});