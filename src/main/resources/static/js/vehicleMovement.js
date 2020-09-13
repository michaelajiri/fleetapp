$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleMovement, status) {
            $('#idEdit').val(vehicleMovement.id);
            $('#ddlLocation1Edit').val(vehicleMovement.location1id);

            var date1 = vehicleMovement.date1.substr(0,10);
            $('#date1Edit').val(vehicleMovement.date1);
            $('#ddlLocation2Edit').val(vehicleMovement.location2id);

            var date2 = vehicleMovement.date2.substr(0,10);
            $('#date2Edit').val(vehicleMovement.date2);
            $('#remarksEdit').val(vehicleMovement.remarks);
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
