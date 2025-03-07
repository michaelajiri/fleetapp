$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleMake, status) {
            $('#idEdit').val(vehicleMake.id);
            $('#descriptionEdit').val(vehicleMake.description);
            $('#detailsEdit').val(vehicleMake.details);
        });

        $('#editModal').modal();
    });

    $('.table .detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicleMake, status){
            $('#idDetails').val(vehicleMake.id);
            $('#createdByDetails').val(vehicleMake.createdBy);
            $('#createdDateDetails').val(vehicleMake.createdDate.substr(0,19).replace("T", " "));
            $('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });
});
