$(function() {

    $(".sortable").sortable({
        update: function(event, ui) {
            $('ul.sortable li').each(function(index, value) {
                var teamId = $(this).attr('id');
                console.log(index + 1 + " : " + teamId)
                $('#bet_p' + (index + 1)).val(teamId);
            });
        }
    });

    $("ul, li").disableSelection();

    $('input:submit').button();
});