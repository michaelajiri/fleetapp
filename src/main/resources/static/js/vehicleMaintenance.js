$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleMaintenance, status) {
            $('#idEdit').val(vehicleMaintenance.id);
            $('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);
            $('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);

            var startDate = vehicleMaintenance.startDate.substr(0,10);
            var endDate = vehicleMaintenance.endDate.substr(0,10);

            $('#startDateEdit').val(vehicleMaintenance.startDate);
            $('#endDateEdit').val(vehicleMaintenance.endDate);
            $('#priceEdit').val(vehicleMaintenance.price);
            $('#remarksEdit').val(vehicleMaintenance.remarks);
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
