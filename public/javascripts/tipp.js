$(function() {

    $(".sortable").sortable({
        update: function(event, ui) {
            $('ul.sortable li').each(function(index, value) {
                console.log(index + 1 + " : " + $(this).attr('id'))
                $('#bet_p' + (index + 1)).val($(this).attr('id'));
            });
        }
    });

    $("ul, li").disableSelection();

    $('input:submit').button();
});