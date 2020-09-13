$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (location, status) {
            $('#idEdit').val(location.id);
            $('#descriptionEdit').val(location.description);
            $('#detailsEdit').val(location.details);
            $('#cityEdit').val(location.city);
            $('#addressEdit').val(location.address);
        });
        $('#editModal').modal();
    });

    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });
});
