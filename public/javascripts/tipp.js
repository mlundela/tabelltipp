$(function() {

    $("#sortable").sortable({
        placeholder: "ui-state-highlight",
        cursor: 'pointer',
        update: function(event, ui) {
            $('li').each(function(index, value) {
                $('#tips_' + index).val($(this).attr('id'));
            });

        }
    });

    $("ul, li").disableSelection();

    $('input:submit').button();
});