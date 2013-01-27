$(function() {

    $("#sortable").sortable({
        placeholder: "ui-state-highlight",
        update: function(event, ui) {
            $('li').each(function(index, value) {
                $('#bet_p' + (index + 1)).val($(this).attr('id'));
                console.log("bet_p"+ (index + 1) + " = " + $(this).attr('id'))
            });
        }
    });

    $("ul, li").disableSelection();

    $('input:submit').button();
});