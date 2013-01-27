$(function() {

    $("#sortable").sortable({
        update: function(event, ui) {
            $('li').each(function(index, value) {
                $('#bet_p' + (index + 1)).val($(this).attr('id'));
            });
        }
    });

    $("ul, li").disableSelection();

    $('input:submit').button();
});