$(function() {

    $("#sortable").sortable({
        placeholder: "ui-state-highlight",
        update: function(event, ui) {
            console.log("\nRekkefølge:");
            $('li').each(function(index, value) {
                console.log($(this).html() + ' ' + $(this).attr('id'));
                $('#tips_' + (index + 1)).val($(this).attr('id'));
            });

        }
    });

    $("#draggable").draggable({
        connectToSortable: "#sortable",
        helper: "clone",
        revert: "invalid"
    });

    $("ul, li").disableSelection();
});